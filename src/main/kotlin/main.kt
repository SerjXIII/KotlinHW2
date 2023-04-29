import java.util.*

fun main() {
    while (true) {
        println(
            """
            Введите номер задачи:
            1. Задача №1 (Комиссия за перевод)
            2. Задача №2 (Количество лайков)
            3. Задача №3 (Меломан)
            4. Выход
            """.trimIndent()
        )

        when (readln().toInt()) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> return
        }
    }
}

fun task1() {
    val feeAmount = 0.0075
    val minFee = 35

    println("\nВведите сумму перевода:")
    val amount = readln().toInt()
    if (amount < minFee) {
        println("Сумма перевода не должна быть меньше размера комиссии (35 рублей).\n")
        return
    }
    val fee = (amount * feeAmount).toInt()

    println("Комиссия за перевод составит: ${if (fee >= minFee) fee else minFee} рублей.\n")
}

fun task2() {
    println("\nВведите количество лайков:")
    val likes = readln().toInt()

    val ending = when {
        likes % 10 == 1 && likes % 100 != 11 -> "лайк"
        likes % 10 in 2..4 && likes % 100 !in 12..14 -> "лайка"
        else -> "лайков"
    }

    println("У Вас $likes $ending \n")
}

fun task3() {
    println("\nВведите сумму покупки:")
    val amount = readln().toInt()

    println("\nУ вас были покупки в прошлом месяце? Да/Нет")
    val regularCustomer = readln().lowercase(Locale.getDefault()) == "да"

    val discount = when {
        amount <= 1000 -> 0
        amount in 1001..10000 -> 100
        else -> (amount * 0.05).toInt()
    }

    val totalAmount = when {
        regularCustomer -> ((amount - discount) * 0.99).toInt()
        else -> amount - discount
    }

    println("\nИтоговая сумма покупки : $totalAmount рублей.\n")
}
