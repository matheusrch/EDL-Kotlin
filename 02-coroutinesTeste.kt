import kotlinx.coroutines.*

class App {  // declaração da classe App
    val greeting: String
        get() {  // método getter da variável greeting da classe App
            return "Hello World App!"
        }
}

fun teste1() = "Teste1"  // a função simplesmente retorna a String "Teste1"

suspend fun main(args: Array<String>) = coroutineScope {
    println(App().greeting)  // imprime o retorno do método get() de greeting, "Hello World App!"

    GlobalScope.launch {  // cria uma nova coroutine global
        delay(2000L)  // delay de 2 segundos
        println("World!")
    }
    println("Hello ")
    Thread.sleep(1000L)  // delay de 1 segundo

    repeat(1_000) {  // repete 1000 vezes
        launch {  // cria uma nova coroutine (como está dentro do repeat, são criadas 1000 coroutines)
            delay(4000L)  // delay de 4 segundos
            print(".")
        }
    }

    for (i in 0 until 10) {  // laço-for de 0 a 9 exclusivo
        launch {  // cria uma nova coroutine (assim como no caso do repeat, são criadas 10 coroutines)
            delay(1000L - i * 10)  // delay de 1000 - i * 10 milissegundos
            print("$i ")
        }
    }

    println(teste1())
}
