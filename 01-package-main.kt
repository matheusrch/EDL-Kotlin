package Main

import Funcs.*  // importa toda a biblioteca Funcs
import Cachorros.*  // importa toda a biblioteca Cachorros

fun main() {
    imprimirMensagem("Hello")  // imprime a mensagem, "Hello"
    imprimirMensagemComPrefixo("Hello", "Log")  // imprime a mensagem com prefixo, "[Log] Hello"
    imprimirMensagemComPrefixo("Hello")  // imprime a mensagem com o prefixo padrão, "[Info] Hello"
    imprimirMensagemComPrefixo(prefixo = "Log", msg = "Hello")  // como cada parâmetro está explicitamente especificado, a ordem dos parâmetros não importa, "[Log] Hello"
    println(soma(1, 2))  // imprime 1 + 2, 3
    println(multiplica(3, 4))  // imprime 3 * 4, 12

    val c: Cachorro = Yorkshire()  // cria uma variável do tipo Yorkshire
    c.latir()  // imprime a mensagem do cachorro, "wif wif!"
}
