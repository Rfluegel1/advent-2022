def printMarkerIndex(String input, int markerLength) {
    def characters = input.toCharArray().toList()
    for (int i = 0; i < characters.size(); i++) {
        if (characters[i..i + markerLength - 1].toSet().size() == markerLength) {
            println(i + markerLength)
            break
        } else {
            def duplicateChar = characters[i]
            int firstIndexOfChar = characters[i..i + markerLength - 1].indexOf(duplicateChar)
            i += firstIndexOfChar
        }
    }
}

printMarkerIndex(input, 4)
printMarkerIndex(input, 14)
