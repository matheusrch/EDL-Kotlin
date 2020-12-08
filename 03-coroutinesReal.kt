suspend fun loadContributorsConcurrent(service: GitHubService, req: RequestData): List<User> = coroutineScope {  // 1
    val repos = service
        .getOrgRepos(req.org)
        .also { logRepos(req, it) }
        .bodyList()
    val deferreds: List<Deferred<List<User>>> = repos.map { repo ->
        async(Dispatchers.Default) {  // 2
            log("starting loading for ${repo.name}")
            service.getRepoContributors(req.org, repo.name)
                .also { logUsers(repo, it) }
                .bodyList()
        }
    }
    deferreds.awaitAll().flatten().aggregate()  // 3
}

// Esse trecho de código foi tirado de https://github.com/kotlin-hands-on/intro-coroutines e https://play.kotlinlang.org/hands-on/overview. O objetivo do programa é carregar todos os contribuidores e a respectiva quantidade de contribuições de todos os repositórios de uma organização.
// A função loadContributorsConcurrent carrega os dados de maneira concorrente utilizando coroutines. A implementação não será explicada, somente as partes que envolvem coroutines.
// Em 1, temos a declaração da função, que é uma função "suspensa" (suspend fun). Esse tipo de função possui esse nome pois pode ser suspensa sem bloquear a thread, permitindo que a função seja pausada e resumida. No final da declaração da função, temos "= coroutineScope". Isso permite o uso de coroutines (geralmente inicializadas a partir das funções launch, async e runBlocking), já que elas somente podem ser criadas nesse escopo.
// Em 2, temos a função async, que criará uma quantidade de coroutines baseada no número de repositórios e na quantidade de contribuidores de cada um. Cada coroutine retornará um objeto Deferred, que armazenará o seu resultado, porém terá o seu retorno adiado. Como cada solicitação é criada em uma nova coroutine, elas acabam sendo iniciadas de maneira assíncrona; assim uma nova solicitação pode ser enviada antes do resultado da anterior ser recebido, permitindo então executar de maneira simultânea. Além disso, a função async está recebendo como argumento "Dispatchers.Default", que representa um conjunto compartilhado de threads da JVM, permitindo que cada coroutine possa ser iniciada em uma certa thread e posteriormente retomada em outra.
// Em 3, temos a função awaitAll, que serve justamente para obter os resultados das coroutines. Normalmente, é utilizada a função await, mas como nesse caso é uma lista de Deferred, a função awaitAll espera pelo resultado de todos os objetos.
