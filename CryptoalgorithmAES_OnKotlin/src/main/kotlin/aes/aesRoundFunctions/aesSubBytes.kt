package aes.aesRoundFunctions

import aes.aesConstants.sBox

//Процедура subBytes
//Производим замену байт во входной матрице, используя sBox(таблица замен)
fun subBytes(inputArray: Array<Array<UByte>>): Array<Array<UByte>> {
    val firstRow = mutableListOf<UByte>()
    val secondRow = mutableListOf<UByte>()
    val thirdRow = mutableListOf<UByte>()
    val fourthRow = mutableListOf<UByte>()
    for (i in 0..3)
        for (j in 0..3) {
            val inHex = inputArray[i][j].toString(16)
            val inHexAdded = if (inHex.length == 2) inHex else "0$inHex"
            val row = Integer.parseInt(inHexAdded[0].toString(), 16)
            val col = Integer.parseInt(inHexAdded[1].toString(), 16)
            when (i) {
                0 -> firstRow.add(sBox[row][col])
                1 -> secondRow.add(sBox[row][col])
                2 -> thirdRow.add(sBox[row][col])
                3 -> fourthRow.add(sBox[row][col])
            }
        }

    return arrayOf(firstRow.toTypedArray(), secondRow.toTypedArray(), thirdRow.toTypedArray(), fourthRow.toTypedArray())
}
