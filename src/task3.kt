import Currency.EUR
import Currency.UAH
import Currency.USD
data class Trader(val name: String, val city: String)
data class Transaction(val trader: Trader, val year: Int, val month: Int, val
value: Int, val currency: Currency)
enum class Currency {
    UAH, USD, EUR
}
fun main() {
    val raoul = Trader("Raoul", "Cambridge")
    val mario = Trader("Mario", "Milan")
    val alan = Trader("Alan", "Cambridge")
    val brian = Trader("Brian", "Cambridge")
    val transactions = listOf(
        Transaction(brian, 2011, 12, 300, UAH),
        Transaction(raoul, 2012, 10, 1000, UAH),
        Transaction(raoul, 2011, 11, 400, USD),
        Transaction(mario, 2012, 9, 710, UAH),
        Transaction(mario, 2012, 7, 700, USD),
        Transaction(alan, 2012, 4, 950, EUR)
    )

    val traders = listOf(raoul, mario, alan, brian)

    val allTransactions2011 = transactions.filter { it.year == 2011 }.sortedBy { it.value }

    println(allTransactions2011)
//-----------------------------------------

    val uniqueCities = traders.map { it.city }.distinct()

    println(uniqueCities)

//-----------------------------------------

    val cambridgeTraders = traders.filter { it.city == "Cambridge" }.sortedBy { it.name }

    println(cambridgeTraders)

//-----------------------------------------

    val traderNames = traders.map { it.name }.sorted().joinToString(", ")

    println(traderNames)

//-----------------------------------------

    val hasTradersInMilan = traders.any { it.city == "Milan" }

    println("Are there traders in Milan? $hasTradersInMilan")

//-----------------------------------------

        val transactionValuesInCambridge = transactions.filter { it.trader.city == "Cambridge" }.map { it.value }

        println(transactionValuesInCambridge)

//-----------------------------------------

        val highestTransactionValue = transactions.maxByOrNull { it.value }

        println(highestTransactionValue)

//-----------------------------------------

    val transactionsByCurrency = transactions.groupBy { it.currency }

    println(transactionsByCurrency)

//-----------------------------------------

    val transactionsInUAH = transactions.filter { it.currency == UAH }.sumOf { it.value }

    println(transactionsInUAH)

//-----------------------------------------

    val sortedTransactions = transactions.sortedWith(compareBy({ it.year }, { it.month }))

    val transactionStrings = sortedTransactions.mapIndexed { index, transaction ->
        "${index + 1}. ${transaction.month}-${transaction.year}: ${transaction.value} ${transaction.currency}"
    }.joinToString(" -> ")

    println(transactionStrings)
}
