//  Завдання 2
fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(5, 6)

    val pairs = list1.flatMap { a -> list2.map { b -> arrayOf(a, b) } }
    println(pairs.map { it.toList() })
}
