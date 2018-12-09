import junit.framework.Assert.assertEquals
import org.junit.Test

class FindBoxesTest {

    @Test
    fun charDiffCountIsOne_noneSingleChar_returnsFalse() {
        assertEquals(false, charDiffCountIsOne(Pair("a", "a")))
    }

    @Test
    fun charDiffCountIsOne_noneTwoChars_returnsFalse() {
        assertEquals(false, charDiffCountIsOne(Pair("ab", "ab")))
    }

    @Test
    fun charDiffCountIsOne_noneFiveChars_returnsFalse() {
        assertEquals(false, charDiffCountIsOne(Pair("abcde", "abcde")))
    }

    @Test
    fun charDiffCountIsOne_oneSingleChar_returnsTrue() {
        assertEquals(true, charDiffCountIsOne(Pair("a", "b")))
    }

    @Test
    fun charDiffCountIsOne_oneTwoChars_returnsTrue() {
        assertEquals(true, charDiffCountIsOne(Pair("ab", "ac")))
    }

    @Test
    fun charDiffCountIsOne_oneFiveChars_returnsTrue() {
        assertEquals(true, charDiffCountIsOne(Pair("abcde", "abcdd")))
    }

    @Test
    fun charDiffCountIsOne_twoTwoChars_returnsFalse() {
        assertEquals(false, charDiffCountIsOne(Pair("ab", "cd")))
    }

    @Test
    fun charDiffCountIsOne_twoFiveChars_returnsFalse() {
        assertEquals(false, charDiffCountIsOne(Pair("abcde", "abccc")))
    }

    @Test
    fun findBoxIdsWithOneDiff_none_returnsNull() {
        assertEquals(null, findBoxIdsWithOneDiff(listOf("abcde", "abcde")))
    }

    @Test
    fun findBoxIdsWithOneDiff_only_returnsPair() {
        assertEquals(Pair("abcde", "abcdf"), findBoxIdsWithOneDiff(listOf("abcde", "abcdf")))
    }

    @Test
    fun findBoxIdsWithOneDiff_lastPair_returnsPair() {
        assertEquals(Pair("abcde", "abcdf"), findBoxIdsWithOneDiff(listOf("abcde", "xxxxx", "abcdf")))
    }

    @Test
    fun findBoxIdsWithOneDiff_mixedPair_returnsPair() {
        assertEquals(Pair("abcde", "abcdf"), findBoxIdsWithOneDiff(listOf("xxxxx", "xxxxx", "abcde", "xxxxx", "abcdf", "xxxxx")))
    }

    @Test
    fun extractCommonChars_none_returnsNull() {
        assertEquals("", extractCommonChars(Pair("abcde", "fghij")))
    }

    @Test
    fun extractCommonChars_first_returnsFirst() {
        assertEquals("a", extractCommonChars(Pair("abcde", "aghij")))
    }

    @Test
    fun extractCommonChars_firstAndLast_returnsFirstAndLast() {
        assertEquals("ae", extractCommonChars(Pair("abcde", "aghie")))
    }

    @Test
    fun extractCommonChars_allButOne_returnsAllButOne() {
        assertEquals("abde", extractCommonChars(Pair("abcde", "abgde")))
    }

    @Test
    fun findBoxes_testData() {
        assertEquals("fgij", findBoxes(loadChanges("findBoxesTest.txt")))
    }

    @Test
    fun findBoxes_realData() {
        assertEquals("mxhwoglxgeauywfkztndcvjqr", findBoxes(loadChanges("boxIds.txt")))
    }
}