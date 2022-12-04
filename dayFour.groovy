
def partOne(List sectionAssignmentPairs) {
    int fullyContainsCount = 0
    sectionAssignmentPairs.each { String sectionAssignmentPair ->
        List sectionAssignments = sectionAssignmentPair.split(',')
        if (doesFullyContain(sectionAssignments[0], sectionAssignments[1])) {
            fullyContainsCount++
        }
    }
    println(fullyContainsCount)
}

partOne(sectionAssignmentPairs)

def partTwo(List sectionAssignmentPairs) {
    int anyContainsCount = 0
    sectionAssignmentPairs.each { String sectionAssignmentPair ->
        List sectionAssignments = sectionAssignmentPair.split(',')
        if (doesContainAny(sectionAssignments[0], sectionAssignments[1])) {
            anyContainsCount++
        }
    }
    println(anyContainsCount)
}

partTwo(sectionAssignmentPairs)

def doesFullyContain(String firstRange, String secondRange) {
    List firstIds = (firstRange.split('-')[0] as int)..(firstRange.split('-')[1] as int)
    List secondIds = (secondRange.split('-')[0] as int)..(secondRange.split('-')[1] as int)
    return firstIds.containsAll(secondIds) || secondIds.containsAll(firstIds)
}

def doesContainAny(String firstRange, String secondRange) {
    Set firstIds = (firstRange.split('-')[0] as int)..(firstRange.split('-')[1] as int) as Set
    Set secondIds = (secondRange.split('-')[0] as int)..(secondRange.split('-')[1] as int) as Set
    return !!firstIds.intersect(secondIds)
}
