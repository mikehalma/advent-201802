import java.io.File
import java.nio.charset.Charset

fun containsLetterXTimes(boxId :String, numberOfTimes :Int): Boolean {
    return boxId.toCharArray()
        .groupBy { it }
        .map { it.value.size }
        .filter { it == numberOfTimes }
        .count() > 0
}

fun getCounts(boxIds :List<String>): List<Int> {
    val twos = boxIds.map { containsLetterXTimes(it, 2)}.filter { it }.count()
    val threes = boxIds.map { containsLetterXTimes(it, 3)}.filter { it }.count()
    return listOf(twos, threes)
}

fun getChecksum(boxIds :List<String>): Int {
    val ( twos, threes ) = getCounts(boxIds)
    return twos * threes
}

fun loadChanges(fileName :String) :List<String> {
    return File(object {}.javaClass.getResource(fileName).toURI()).readLines(Charset.defaultCharset())
}