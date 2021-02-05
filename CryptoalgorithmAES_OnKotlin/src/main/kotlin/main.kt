import aes.aesRoundFunctions.mixColumns
import aes.aesRoundFunctions.shiftRows
import aes.aesRoundFunctions.subBytes
import java.security.MessageDigest


fun main(args: Array<String>) {
    val inputText = "Two One Nine Two"
    //Представление входного текста в виде массива десятичных байт(беззнаковых)
    val byteArr = inputText.toByteArray(Charsets.US_ASCII).map { it -> it.toUByte() }.toTypedArray()

    //Коробочка
    val myBox = takeBoxOfBytes(byteArr)
    subBytes(myBox)

    shiftRows(myBox)

    mixColumns(myBox)
    println(256U.toUByte())
    val inputPassword="MyPassword=)"
    //используется хэширование по алгоритму md2 для получения хэша в 128 бит
    val messageDigest= MessageDigest.getInstance("md2")
    val hash = messageDigest.digest(inputPassword.toByteArray(Charsets.US_ASCII)).map{it->it.toUByte()}.toTypedArray()


    println()
}


fun printMatrix(input: Array<Array<UByte>>) =
    input.forEach { array -> array.forEach { elem -> print(elem.toString(16) + "    ") }; println() }

//Складываем байты в матрицу размерности 4х4 (Вообще говоря, вероятно можно обойтись и без этого)
fun takeBoxOfBytes(inputBytes: Array<UByte>): Array<Array<UByte>> {
    val firstRow = mutableListOf<UByte>()
    val secondRow = mutableListOf<UByte>()
    val thirdRow = mutableListOf<UByte>()
    val fourthRow = mutableListOf<UByte>()

    for (i in inputBytes.indices)
        when {
            i < 4 -> firstRow.add(inputBytes[i])
            i < 8 -> secondRow.add(inputBytes[i])
            i < 12 -> thirdRow.add(inputBytes[i])
            i < 16 -> fourthRow.add(inputBytes[i])
        }


    return arrayOf(firstRow.toTypedArray(), secondRow.toTypedArray(), thirdRow.toTypedArray(), fourthRow.toTypedArray())
}
