package Funcs

fun imprimirMensagem(msg: String): Unit {  // imprime o parâmetro passado
    println(msg)
}

fun imprimirMensagemComPrefixo(msg: String, prefixo: String = "Info") {  // imprime a mensagem e o prefixo passados; caso não seja passado nenhum prefixo, utiliza-se o padrão "Info"
    println("[$prefixo] $msg")
}

fun soma(x: Int, y: Int): Int {  // retorna a soma dos parâmetros passados
    return x + y
}

fun multiplica(x: Int, y: Int) = x * y  // retorna a multiplicação dos parâmetros passados
