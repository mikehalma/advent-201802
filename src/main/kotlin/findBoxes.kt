fun charDiffCountIsOne(boxIds: Pair<String, String>): Boolean {
    return zipChars(boxIds)
        .filter { it.first != it.second }
        .count() == 1
}

private fun zipChars(boxIds: Pair<String, String>) =
    boxIds.first.toCharArray().zip(boxIds.second.toCharArray())

fun findBoxIdsWithOneDiff(boxIds: List<String>): Pair<String, String>? {
    if (boxIds.size < 2) return null

    val oneDiffPair : Pair<String, String>? =
        boxIds.drop(1)
            .map {Pair(boxIds[0], it)}
            .firstOrNull {charDiffCountIsOne(it)}

    return oneDiffPair?:findBoxIdsWithOneDiff(boxIds.drop(1))
}

fun extractCommonChars(boxIds: Pair<String, String>): String {
    return zipChars(boxIds)
        .filter { it.first == it.second}
        .map { it.first }
        .joinToString("")
}

fun findBoxes(boxIds: List<String>) :String {
    val boxes = findBoxIdsWithOneDiff(boxIds)
    return if (boxes != null) extractCommonChars(boxes) else ""
}