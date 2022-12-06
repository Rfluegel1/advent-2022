def printMarkerIndex(String input, int markerLength) {
    def characters = input.toCharArray().toList()
    for (int i = 0; i < characters.size(); i++) {
        if (characters[i..i + markerLength - 1].toSet().size() == markerLength) {
            println(i + markerLength)
            break
        }
    }
}

printMarkerIndex(input, 4)
printMarkerIndex(input, 14)
