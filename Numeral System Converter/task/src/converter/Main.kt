package converter

import kotlin.math.pow

fun main() {

    try {
        val sourceBase = readLine()!!.toInt()
        val number = readLine()!!.toString().split(".")
        val newBase = readLine()!!.toInt()


        if (number.size == 1) {

            println(changeBaseInt(sourceBase, number.first(), newBase))
        } else {

            println("${changeBaseInt(sourceBase, number.first(), newBase)}." +
                    changeBaseFraction(sourceBase, number.last(), newBase))
        }
    } catch (e: Exception) {

        println("error")
    }

}

fun changeBaseInt(sourceBase: Int, number: String, newBase: Int): String {

    if (sourceBase == 1) {

        return number.length.toString(newBase)

    } else {

        var n = ""
        return if (newBase == 1) {

            repeat(number.toInt(10)) {

                n += 1
            }
            n
        } else {

            number.toInt(sourceBase).toString(newBase)
        }
    }
}

fun changeBaseFraction(sourceBase: Int, number: String, newBase: Int): String {

    val len = number.length
    var nConvert = 0.0

    for (i in 1..len) {

        nConvert += number[i-1].toString().toInt(sourceBase) / sourceBase.toDouble().pow(i.toDouble())
    }

    val firstDigit = (nConvert * newBase)
    val secondDigit = firstDigit % 1 * newBase
    val thirdDigit = secondDigit % 1 * newBase
    val fourthDigit = thirdDigit % 1 * newBase
    val fifthDigit = fourthDigit % 1 * newBase

    return firstDigit.toInt().toString(newBase) + secondDigit.toInt().toString(newBase) +
            thirdDigit.toInt().toString(newBase) + fourthDigit.toInt().toString(newBase) +
            fifthDigit.toInt().toString(newBase)

}