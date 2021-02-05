package aes.aesRoundFunctions
// Процедура AddRoundKey
// Производит поэлементный xor элементов двух матриц (Входного массива с раундовыми ключами)
fun addRoundKey(inputArray: Array<Array<UByte>>, roundKey: Array<Array<UByte>>): Array<Array<UByte>> {
    val result = Array<Array<UByte>>(4) { arrays -> Array<UByte>(4) { elem -> 0U } }
    for (i in 0..3)
        for (j in 0..3)
            result[i][j] = inputArray[i][j] xor roundKey[i][j]
    return result
}

