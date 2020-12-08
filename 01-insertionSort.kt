fun insertionSort(arr: IntArray) : IntArray {
    for (i in 1 until arr.size) {
        var t = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > t) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = t
    }
    return arr
}

fun main() {
    val arr: IntArray = intArrayOf(50, 68, 94, 37, 26, 80, 15, 44, 7)  // cria um array de inteiros
    for (i in arr)  // laço-for para imprimir os valores do array original
        print("$i ")
    println()

    val arrOrd: IntArray = insertionSort(arr)  // retorna o array ordenado por Insertion Sort para a variável arrOrd
    for (i in arrOrd)  // laço-for para imprimir os valores do array ordenado
        print("$i ")
}
