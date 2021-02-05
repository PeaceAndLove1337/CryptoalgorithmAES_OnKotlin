package aes.aesRoundFunctions

import aes.ushl

// Процедура MixColumns
// Смешивает байты используя линейную трансформацию в конечном поле Галуа 2^8, привнося диффузию в шифр
fun mixColumns(inputArray: Array<Array<UByte>>): Array<Array<UByte>> {

    val firstRow = mutableListOf<UByte>()
    val secondRow = mutableListOf<UByte>()
    val thirdRow = mutableListOf<UByte>()
    val fourthRow = mutableListOf<UByte>()


    val constMatrix =
        arrayOf(arrayOf(2, 3, 1, 1), arrayOf(1, 2, 3, 1), arrayOf(1, 1, 2, 3), arrayOf(3, 1, 1, 2))

    val result = arrayOf(firstRow, secondRow, thirdRow, fourthRow)


    for (k in 0..3) {
        for (i in 0..3) {
            var currRes: UByte = 0x00U.toUByte()
            for (j in 0..3) {
                currRes = currRes xor executeElemOfMatrix(inputArray[j][i], constMatrix[k][j])
            }
            result[k].add(currRes)
        }
    }
    return result.map { it -> it.toTypedArray() }.toTypedArray()
}

//Подпроцедура вычисления произведения байта на элемент матрицы (в процедуре MixColumns)
fun executeElemOfMatrix(elem: UByte, action: Int): UByte {


    fun firstOperation(input: UByte): UByte = input

    fun secondOperation(input: UByte): UByte {
        val result = input ushl 1
        //Если старший бит равен 1, то xor'им число 1B
        val inputInBinary = input.toString(2)
        return if (inputInBinary.length == 8 && inputInBinary[0] == '1')
            result xor (0x1bU).toUByte()
        else
            result
    }

    fun thirdOperation(input: UByte): UByte {
        return secondOperation(input) xor input
    }
    return when (action) {
        1 -> firstOperation(elem)
        2 -> secondOperation(elem)
        3 -> thirdOperation(elem)
        else -> throw Exception()
    }

}

