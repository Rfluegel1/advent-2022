def partOne(List<List> stacks, List directions) {
    directions.each { String direction ->
        List directionInfo = direction.split(' ')
        int move = directionInfo[1] as int
        int from = directionInfo[3] as int
        int to = directionInfo[5] as int
        (1..move).each {
            String box = stacks[from].pop()
            stacks[to].push(box)
        }
    }
    stacks.each {
        if (!!it.size()) {
         print(it.pop())
        }
    }
    println()
}

partOne(startingStacks, directions)

def partTwo(List<List> stacks, List directions) {
    directions.each { String direction ->
        List directionInfo = direction.split(' ')
        int move = directionInfo[1] as int
        int from = directionInfo[3] as int
        int to = directionInfo[5] as int
        List list = stacks[from]
        List popped = list[0..move-1]
        if (move == list.size()) {
            stacks[from] = []
        } else {
            stacks[from] = list[move..list.size() - 1]
        }
        List boxes = popped
        boxes.addAll(stacks[to])
        stacks[to] = boxes
    }
    stacks.each {
        if (!!it.size()) {
            print(it.pop())
        }
    }
    println()
}

startingStacks = [
        [],
        ['C', 'S', 'G', 'B'],
        ['G', 'V', 'N', 'J', 'H', 'W', 'M', 'T'],
        ['S', 'Q', 'M'],
        ['M', 'N', 'W', 'T', 'L', 'S', 'B'],
        ['P', 'W', 'G', 'V', 'T', 'F', 'Z', 'J'],
        ['S', 'H', 'Q', 'G', 'B', 'T', 'C'],
        ['W', 'B', 'P', 'J', 'T'],
        ['M', 'Q', 'T', 'F', 'Z', 'C', 'D', 'G'],
        ['F', 'P', 'B', 'H', 'S', 'N']
]

partTwo(startingStacks, directions)


