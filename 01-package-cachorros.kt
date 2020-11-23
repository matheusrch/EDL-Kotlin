package Cachorros

open class Cachorro {  // declaração da classe Cachorro, aberta para extensões/mudanças
    open fun latir() {  // função da classe Cachorro que pode ser alterada por override
        println("wow wow!")
    }
}

class Yorkshire : Cachorro() {  // declaração da classe Yorkshire, que herda de Cachorro
    override fun latir() {  // aqui o método latir é substituído
        println("wif wif!")
    }
}
