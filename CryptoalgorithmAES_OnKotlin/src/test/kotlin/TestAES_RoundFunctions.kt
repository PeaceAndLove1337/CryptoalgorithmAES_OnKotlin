import aes.aesRoundFunctions.mixColumns
import aes.aesRoundFunctions.shiftRows
import aes.aesRoundFunctions.subBytes
import org.junit.Assert
import org.junit.Test



    class SubBytesTesting {
        @Test
        fun subBytesTest1() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x00U, 0x3cU, 0x6eU, 0x47U),
                arrayOf<UByte>(0x1fU, 0x4eU, 0x22U, 0x74U),
                arrayOf<UByte>(0x0eU, 0x08U, 0x1bU, 0x31U),
                arrayOf<UByte>(0x54U, 0x59U, 0x0bU, 0x1aU),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x63U, 0xebU, 0x9fU, 0xa0U),
                    arrayOf<UByte>(0xc0U, 0x2fU, 0x93U, 0x92U),
                    arrayOf<UByte>(0xabU, 0x30U, 0xafU, 0xc7U),
                    arrayOf<UByte>(0x20U, 0xcbU, 0x2bU, 0xa2U),
                )
            Assert.assertArrayEquals(subBytes(inputBox), expectedBox)
        }

        @Test
        fun subBytesTest2() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x19U, 0xa0U, 0x9aU, 0xe9U),
                arrayOf<UByte>(0x3dU, 0xf4U, 0xc6U, 0xf8U),
                arrayOf<UByte>(0xe3U, 0xe2U, 0x8dU, 0x48U),
                arrayOf<UByte>(0xbeU, 0x2bU, 0x2aU, 0x08U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0xd4U, 0xe0U, 0xb8U, 0x1eU),
                    arrayOf<UByte>(0x27U, 0xbfU, 0xb4U, 0x41U),
                    arrayOf<UByte>(0x11U, 0x98U, 0x5dU, 0x52U),
                    arrayOf<UByte>(0xaeU, 0xf1U, 0xe5U, 0x30U),
                )
            Assert.assertArrayEquals(subBytes(inputBox), expectedBox)
        }

        @Test
        fun subBytesTest3() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0xa4U, 0x68U, 0x6bU, 0x02U),
                arrayOf<UByte>(0x9cU, 0x9fU, 0x5bU, 0x6aU),
                arrayOf<UByte>(0x7fU, 0x35U, 0xeaU, 0x50U),
                arrayOf<UByte>(0xf2U, 0x2bU, 0x43U, 0x49U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x49U, 0x45U, 0x7fU, 0x77U),
                    arrayOf<UByte>(0xdeU, 0xdbU, 0x39U, 0x02U),
                    arrayOf<UByte>(0xd2U, 0x96U, 0x87U, 0x53U),
                    arrayOf<UByte>(0x89U, 0xf1U, 0x1aU, 0x3bU),
                )
            Assert.assertArrayEquals(subBytes(inputBox), expectedBox)
        }

    }

    class ShiftRowsTesting {
        @Test
        fun shiftRowsTest1() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x63U, 0xebU, 0x9fU, 0xa0U),
                arrayOf<UByte>(0xc0U, 0x2fU, 0x93U, 0x92U),
                arrayOf<UByte>(0xabU, 0x30U, 0xafU, 0xc7U),
                arrayOf<UByte>(0x20U, 0xcbU, 0x2bU, 0xa2U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x63U, 0xebU, 0x9fU, 0xa0U),
                    arrayOf<UByte>(0x2fU, 0x93U, 0x92U, 0xc0U),
                    arrayOf<UByte>(0xafU, 0xc7U, 0xabU, 0x30U),
                    arrayOf<UByte>(0xa2U, 0x20U, 0xcbU, 0x2bU),
                )
            Assert.assertArrayEquals(shiftRows(inputBox), expectedBox)
        }

        @Test
        fun shiftRowsTest2() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0xd4U, 0xe0U, 0xb8U, 0x1eU),
                arrayOf<UByte>(0x27U, 0xbfU, 0xb4U, 0x41U),
                arrayOf<UByte>(0x11U, 0x98U, 0x5dU, 0x52U),
                arrayOf<UByte>(0xaeU, 0xf1U, 0xe5U, 0x30U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0xd4U, 0xe0U, 0xb8U, 0x1eU),
                    arrayOf<UByte>(0xbfU, 0xb4U, 0x41U, 0x27U),
                    arrayOf<UByte>(0x5dU, 0x52U, 0x11U, 0x98U),
                    arrayOf<UByte>(0x30U, 0xaeU, 0xf1U, 0xe5U),
                )
            Assert.assertArrayEquals(shiftRows(inputBox), expectedBox)
        }

        @Test
        fun shiftRowsTest3() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x49U, 0x45U, 0x7fU, 0x77U),
                arrayOf<UByte>(0xdeU, 0xdbU, 0x39U, 0x02U),
                arrayOf<UByte>(0xd2U, 0x96U, 0x87U, 0x53U),
                arrayOf<UByte>(0x89U, 0xf1U, 0x1aU, 0x3bU),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x49U, 0x45U, 0x7fU, 0x77U),
                    arrayOf<UByte>(0xdbU, 0x39U, 0x02U, 0xdeU),
                    arrayOf<UByte>(0x87U, 0x53U, 0xd2U, 0x96U),
                    arrayOf<UByte>(0x3bU, 0x89U, 0xf1U, 0x1aU),
                )
            Assert.assertArrayEquals(shiftRows(inputBox), expectedBox)
        }
    }

    class MixColumnsTesting {
        @Test
        fun mixColumnsTest1() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0xd4U, 0xe0U, 0xb8U, 0x1eU),
                arrayOf<UByte>(0xbfU, 0xb4U, 0x41U, 0x27U),
                arrayOf<UByte>(0x5dU, 0x52U, 0x11U, 0x98U),
                arrayOf<UByte>(0x30U, 0xaeU, 0xf1U, 0xe5U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x04U, 0xe0U, 0x48U, 0x28U),
                    arrayOf<UByte>(0x66U, 0xcbU, 0xf8U, 0x06U),
                    arrayOf<UByte>(0x81U, 0x19U, 0xd3U, 0x26U),
                    arrayOf<UByte>(0xe5U, 0x9aU, 0x7aU, 0x4cU),
                )
            Assert.assertArrayEquals(mixColumns(inputBox), expectedBox)
        }

        @Test
        fun mixColumnsTest2() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x49U, 0x45U, 0x7fU, 0x77U),
                arrayOf<UByte>(0xdbU, 0x39U, 0x02U, 0xdeU),
                arrayOf<UByte>(0x87U, 0x53U, 0xd2U, 0x96U),
                arrayOf<UByte>(0x3bU, 0x89U, 0xf1U, 0x1aU),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x58U, 0x1bU, 0xdbU, 0x1bU),
                    arrayOf<UByte>(0x4dU, 0x4bU, 0xe7U, 0x6bU),
                    arrayOf<UByte>(0xcaU, 0x5aU, 0xcaU, 0xb0U),
                    arrayOf<UByte>(0xf1U, 0xacU, 0xa8U, 0xe5U),
                )
            Assert.assertArrayEquals(mixColumns(inputBox), expectedBox)
        }

        @Test
        fun mixColumnsTest3() {
            val inputBox = arrayOf(
                arrayOf<UByte>(0x87U, 0xf2U, 0x4dU, 0x97U),
                arrayOf<UByte>(0x6eU, 0x4cU, 0x90U, 0xecU),
                arrayOf<UByte>(0x46U, 0xe7U, 0x4aU, 0xc3U),
                arrayOf<UByte>(0xa6U, 0x8cU, 0xd8U, 0x95U),
            )

            val expectedBox =
                arrayOf(
                    arrayOf<UByte>(0x47U, 0x40U, 0xa3U, 0x4cU),
                    arrayOf<UByte>(0x37U, 0xd4U, 0x70U, 0x9fU),
                    arrayOf<UByte>(0x94U, 0xe4U, 0x3aU, 0x42U),
                    arrayOf<UByte>(0xedU, 0xa5U, 0xa6U, 0xbcU),
                )
            Assert.assertArrayEquals(mixColumns(inputBox), expectedBox)
        }
    }

    


    /*   arrayOf<UByte>(0xU,0xU,0xU,0xU),
       arrayOf<UByte>(0xU,0xU,0xU,0xU),
       arrayOf<UByte>(0xU,0xU,0xU,0xU),
       arrayOf<UByte>(0xU,0xU,0xU,0xU),*/
