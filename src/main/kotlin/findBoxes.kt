fun charDiffCountIsOne(boxIds: Pair<String, String>): Boolean {
    var oneDiff = false
    boxIds.first.toCharArray().forEachIndexed { index, char ->
        if (boxIds.second.toCharArray()[index] != char) {
            if (!oneDiff) {
                oneDiff = true
            } else {
                return false
            }
        }
    }
    return oneDiff
}

fun findBoxIdsWithOneDiff(boxIds: List<String>): Pair<String, String>? {
    var firstBoxIds = boxIds
    var secondBoxIds = firstBoxIds.drop(1)
    while (secondBoxIds.size > 0) {
        for (firstBoxId in firstBoxIds) {
            for (secondBoxId in secondBoxIds) {
                val pairOfBoxIds = Pair(firstBoxId, secondBoxId)
                if (charDiffCountIsOne(pairOfBoxIds)) {
                    return pairOfBoxIds
                }
            }
        }
        firstBoxIds = secondBoxIds
        secondBoxIds = secondBoxIds.drop(1)
    }
    return null
}

fun extractCommonChars(boxIds: Pair<String, String>): String {
    val commonChars = mutableListOf<Char>()
    boxIds.first.toCharArray().forEachIndexed { index, char ->
        if (char == boxIds.second.toCharArray()[index]) {
            commonChars.add(char)
        }
    }
    return commonChars.joinToString().replace(", ", "")
}

fun findBoxes(boxIds: List<String>) :String {
    val boxes = findBoxIdsWithOneDiff(boxIds)
    return if (boxes != null) extractCommonChars(boxes) else ""
}