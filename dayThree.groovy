def partOne(List rucksacks) {

    int runningTotal = 0

    rucksacks.each { String rucksack ->
        int rucksackLength = rucksack.length()
        int comparmentLength = rucksackLength / 2
        String compartmentOne = rucksack[0..comparmentLength - 1]
        String compartmentTwo = rucksack[comparmentLength..rucksackLength - 1]
        String commonItem = findCommonItem(compartmentOne, compartmentTwo)
        runningTotal += getLetterValue(commonItem)
    }

    println(runningTotal)
}

partOne(rucksacks)

def partTwo(List<String> rucksacks) {
    int runningTotal = 0

    for (int i = 0; i < rucksacks.size(); i += 3) {
        def one = rucksacks[i].toCharArray().toSet()
        def two = rucksacks[i+1].toCharArray().toSet()
        def three = rucksacks[i+2].toCharArray().toSet()
        def oneAndTwoIntersect = one.intersect(two)
        def commonItem = oneAndTwoIntersect.intersect(three)
        runningTotal += getLetterValue(commonItem.first().toString())
    }

    println(runningTotal)
}

partTwo(rucksacks)

String findCommonItem(String thiz, String other) {
    return thiz.toCharArray().find {Character item -> other.contains(item.toString())}.toString()
}

boolean isLowerCase(String letter) {
    return 'abcdefghijklmnopqrstuvwxyz'.contains(letter)
}

int getLetterValue(String letter) {
    if (isLowerCase(letter)) {
        return 'abcdefghijklmnopqrstuvwxyz'.indexOf(letter) + 1
    } else {
        return 'abcdefghijklmnopqrstuvwxyz'.toUpperCase().indexOf(letter) + 26 + 1
    }
}
