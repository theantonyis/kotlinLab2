//Завдання 1, 1а
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val squares = numbers.map { it * it }
    val sumOfSquares = numbers.sumOf { it * it }
    println("Список квадратів кожного числа з прикладу: $squares")
    println("Сума квадратів: $sumOfSquares")
}

