package aes
//Беззнаковый сдвиг влево для UByte
infix fun  UByte.ushl(countOfBytes:Int):UByte{
    return (this.toInt() shl countOfBytes).toUByte()
}