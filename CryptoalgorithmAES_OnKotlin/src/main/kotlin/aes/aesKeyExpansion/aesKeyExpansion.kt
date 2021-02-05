package aes.aesKeyExpansion
// Написать процедуру расширения ключа (Генерация ракундовых ключей из cipherKey)
fun keyExpansion(initialKey:Array<UByte>):Array<UByte>{
    TODO()
}

//Подпроцедура RotWord циклического смещения четырехбайтного слова влево на один байт (в процедуре KeyExpansion)
fun rotWord(inputArray:Array<UByte>):Array<UByte>{
    TODO()
}

// Подпроцедура SubWord замены каждого байта в соответствии с таблицей SubBytes (в процедуре KeyExpansion)
fun subWord(inputArray:Array<UByte>):Array<UByte>{
    TODO()
}


// Подпроцедура xor'а входных четырех байт с раундовой постоянной R[i], равной [RC[i],0,0,0], где RC[1]=1, RC[i]=2*RC[i-1]
fun addConstant(inputArray:Array<UByte>, numberOfRound:Byte):Array<UByte>{
    val RC=arrayOf<UByte>(0x01U,0x02U,0x04U,0x08U,0x10U,0x20U,0x40U,0x80U,0x1BU,0x36U)
    val Rcon=arrayOf<UByte>(RC[numberOfRound.toInt()-1],0U, 0U, 0U)

    val result = mutableListOf<UByte>()
    for (i in 0..3)
        result.add(inputArray[i] xor Rcon.elementAt(i))

    return result.toTypedArray()
}


