class Pessoa { // declaração da classe Pessoa que contém a variável nome como atributo
    var nome : String? = null

    fun mostre() {  // função que mostra o nome da pessoa na tela 
        println(nome)
    }
}

fun main() {
    var p1 = Pessoa()  // cria uma variável do tipo Pessoa
    p1.nome = "Lia"  // atribui um nome ao atributo "nome"

    var p2 = Pessoa()
    p2.nome= "Carla"

    var p3 = p1.Composto(p2)  // cria uma variável do tipo Pessoa a partir da função complementar Composto
    p3.mostre()  // mostra o nome da pessoa na tela, "Lia Carla"
} 

fun Pessoa.Composto(p : Pessoa): Pessoa {  // função complementar com o uso de Extensions, com uma variável p do tipo Pessoa sendo passada como argumento
    var ptemp = Pessoa() // cria uma variável temporária do tipo Pessoa
    ptemp.nome = this.nome + " " + p.nome  // faz o nome da variável temporária ser a concatenação do nome do objeto que a chamou, pelo uso do .this, com o nome da variável p que foi passada como argumento
    return ptemp // retorna a variável temporária
}
