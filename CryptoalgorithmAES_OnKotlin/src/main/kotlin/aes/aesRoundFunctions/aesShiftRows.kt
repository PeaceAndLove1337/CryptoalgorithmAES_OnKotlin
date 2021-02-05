package aes.aesRoundFunctions
// Процедура ShiftRows
// Производит перестановку трех последних строк входной матрицы
fun shiftRows(inputArray: Array<Array<UByte>>): Array<Array<UByte>> {

    val secondRow = arrayOf(inputArray[1][1], inputArray[1][2], inputArray[1][3], inputArray[1][0])
    val thirdRow = arrayOf(inputArray[2][2], inputArray[2][3], inputArray[2][0], inputArray[2][1])
    val fourthRow = arrayOf(inputArray[3][3], inputArray[3][0], inputArray[3][1], inputArray[3][2])
    return arrayOf(inputArray[0], secondRow, thirdRow, fourthRow)
}