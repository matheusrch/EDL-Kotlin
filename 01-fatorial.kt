fun main() {
    print("Insira um número: ")
    var str = readLine()!!  // lê uma string que o usuário digita. o operando "!!" é usado para garantir que a variável str não será nula, evitando erros
    val num:Int = str.toInt()  // transforma a variável str em um int e guarda na variável num
    var i = 1
    var fatorial: Long = 1
    if (num < 0) {  // programa se encerra se o número for negativo
        println("Não existe fatorial de número negativo")
    }
    else if (num == 0) {  // programa imprime 1 se a entrada for 0
       println("Fatorial de $num == 1") 
    }
    else {
        while (i <= num) {  // laço que se repete enquanto i for menor ou igual a num
            fatorial *= i.toLong()  // multiplica o fatorial anterior pelo número i atual
            i++  // adiciona +1 ao i, até chegar ao valor de num
        }
         println("Fatorial de $num = $fatorial")  // imprime o valor da fatorial de num
    }

}
