import junit.framework.Assert.assertEquals
import org.junit.Test

class BoxIdChecksumTest {

    @Test
    fun containsLetterXTimes_noneTwice_returnsFalse() {
        assertEquals(false, containsLetterXTimes("abcdef", 2))
    }

    @Test
    fun containsLetterXTimes2_twoAs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("bababc", 2))
    }

    @Test
    fun containsLetterXTimes2_twoBs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("abbcde", 2))
    }

    @Test
    fun containsLetterXTimes2_threeCsOnly_returnsFalse() {
        assertEquals(false, containsLetterXTimes("abcccd", 2))
    }

    @Test
    fun containsLetterXTimes2_twoAsTwoDs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("aabcdd", 2))
    }

    @Test
    fun containsLetterXTimes2_twoEs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("abcdee", 2))
    }

    @Test
    fun containsLetterXTimes2_threeAsAndBs_returnsFalse() {
        assertEquals(false, containsLetterXTimes("ababab", 2))
    }

    @Test
    fun containsLetterXTimes3_noneTwice_returnsFalse() {
        assertEquals(false, containsLetterXTimes("abcdef", 3))
    }

    @Test
    fun containsLetterXTimes3_threeBs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("bababc", 3))
    }

    @Test
    fun containsLetterXTimes3_twoBs_returnsFalse() {
        assertEquals(false, containsLetterXTimes("abbcde", 3))
    }

    @Test
    fun containsLetterXTimes3_threeCsOnly_returnsTrue() {
        assertEquals(true, containsLetterXTimes("abcccd", 3))
    }

    @Test
    fun containsLetterXTimes3_twoAsTwoDs_returnsFalse() {
        assertEquals(false, containsLetterXTimes("aabcdd", 3))
    }

    @Test
    fun containsLetterXTimes3_twoEs_returnsFalse() {
        assertEquals(false, containsLetterXTimes("abcdee", 3))
    }

    @Test
    fun containsLetterXTimes3_threeAsAndBs_returnsTrue() {
        assertEquals(true, containsLetterXTimes("ababab", 3))
    }

    @Test
    fun getCounts_zero2zero3_returns11() {
        assertEquals(listOf(0, 0), getCounts(listOf("abcdef")))
    }

    @Test
    fun getCounts_one2zero3_returns10() {
        assertEquals(listOf(1, 0), getCounts(listOf("abcdee")))
    }

    @Test
    fun getCounts_zero2one3_returns10() {
        assertEquals(listOf(0, 1), getCounts(listOf("abcddd")))
    }

    @Test
    fun getCounts_one2one3_returns10() {
        assertEquals(listOf(1, 1), getCounts(listOf("abbccc")))
    }

    @Test
    fun getCounts_two2zero3_returns10() {
        assertEquals(listOf(2, 0), getCounts(listOf("aabbcd", "aabbcd")))
    }

    @Test
    fun getCounts_two2one3_returns10() {
        assertEquals(listOf(2, 1), getCounts(listOf("aabbcd", "aabbca")))
    }

    @Test
    fun getCounts_three2two3_returns10() {
        assertEquals(listOf(3, 2), getCounts(listOf("aabbcd", "aabbcd", "aabbbc", "aaabcd")))
    }

    @Test
    fun getChecksum_zero2zero3_returns0() {
        assertEquals(0, getChecksum(listOf("abcdef")))
    }

    @Test
    fun getChecksum_one2zero3_returns0() {
        assertEquals(0, getChecksum(listOf("abcdee")))
    }

    @Test
    fun getChecksum_one2one3_returns1() {
        assertEquals(1, getChecksum(listOf("abbccc")))
    }

    @Test
    fun getChecksum_two2one3_returns2() {
        assertEquals(2, getChecksum(listOf("abbccc", "abcdee")))
    }

    @Test
    fun getChecksum_two2three3_returns6() {
        assertEquals(6, getChecksum(listOf("abbccc", "abcdee", "aaabbb", "bbbccc")))
    }

    @Test
    fun getChecksumFile_two2three3_returns6() {
        assertEquals(6, getChecksum(loadChanges("two2three3.txt")))
    }

    @Test
    fun getChecksumFile_partA_returnsAnswer() {
        assertEquals(6474, getChecksum(loadChanges("boxIds.txt")))
    }

}