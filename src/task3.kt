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

    val filterTransactions = transactions.filter { it.year == 2011 }.sortedBy { it.value }
    val allTransactions2011 = filterTransactions.map { transaction ->
        "Year: ${transaction.year}, Value: ${transaction.value} ${transaction.currency}"
    }.joinToString(" | ")

    println(allTransactions2011 + "\n")
//-----------------------------------------

    val uniqueCities = traders.map { it.city }.distinct()

    println("Унікальні міста: $uniqueCities \n")

//-----------------------------------------

    val cambridgeTraders = traders.filter { it.city == "Cambridge" }.sortedBy { it.name }
    .map { "Trader: ${it.name}, City: ${it.city}" }

    println(cambridgeTraders.joinToString(" | ") + "\n")

//-----------------------------------------

    val traderNames = traders.map { it.name }.sorted().joinToString(", ")

    println("Всі імена трейдерів: $traderNames \n")

//-----------------------------------------

    val hasTradersInMilan = traders.any { it.city == "Milan" }

    println("Чи є трейдери в Мілані? $hasTradersInMilan \n")

//-----------------------------------------

    val transactionValuesInCambridge = transactions.filter { it.trader.city == "Cambridge" }
    .map { "Trader: ${it.trader.name}, City: ${it.trader.city}, Value: ${it.value} ${it.currency}" }

    println(transactionValuesInCambridge.joinToString(" | ") + "\n")

//-----------------------------------------

    val highestTransactionValue = transactions.maxByOrNull { it.value }

    if (highestTransactionValue != null) {
        println("Trader: ${highestTransactionValue.trader.name}, City: ${highestTransactionValue.trader.city}, Value: ${highestTransactionValue.value} ${highestTransactionValue.currency}")
    }

//-----------------------------------------

    val transactionsByCurrency = transactions.groupBy { it.currency }

    transactionsByCurrency.forEach { (currency, transactions) ->
        println("\nCurrency: $currency")
        transactions.forEach { transaction ->
            println("Trader: ${transaction.trader.name}, Year: ${transaction.year}, Month: ${transaction.month}, Value: ${transaction.value} ${transaction.currency}")
        }
    }

//-----------------------------------------

    val transactionsInUAH = transactions.filter { it.currency == UAH }.sumOf { it.value }

    println("\nСума транзакцій в гривнях - $transactionsInUAH \n")

//-----------------------------------------

    val sortedTransactions = transactions.sortedWith(compareBy({ it.year }, { it.month }))

    val transactionStrings = sortedTransactions.mapIndexed { index, transaction ->
        "${index + 1}. ${transaction.month}-${transaction.year}: ${transaction.value} ${transaction.currency}"
    }.joinToString(" -> ")

    println(transactionStrings)
}
