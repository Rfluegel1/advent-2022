enum Result {
    WIN(6, 'X'),
    TIE(3, 'Y'),
    LOSE(0, 'Z')

    final int value
    final String letter

    Result(int value, String letter) {
        this.value = value
        this.letter = letter
    }
}

abstract class Shape {
    int value
    List letters

    boolean isShape(String letter) {
        return letters.contains(letter)
    }

    abstract Result resultOfBattling(Shape other)

    abstract Shape getShapeForResult(Result result)
}

class Rock extends Shape {

    Rock() {
        value = 1
        letters = ['A', 'X']
    }

    Result resultOfBattling(Shape other) {
        if (other instanceof Paper) {
            return Result.LOSE
        } else if (other instanceof Scissor) {
            return Result.WIN
        } else {
            return Result.TIE
        }
    }

    Shape getShapeForResult(Result result) {
        if (result == Result.WIN) {
            return new Scissor()
        } else if (result == Result.TIE) {
            return new Rock()
        } else {
            return new Paper()
        }
    }
}

class Paper extends Shape {

    Paper() {
        value = 2
        letters = ['B', 'Y']
    }

    Result resultOfBattling(Shape other) {
        if (other instanceof Rock) {
            return Result.WIN
        } else if (other instanceof Scissor) {
            return Result.LOSE
        } else {
            return Result.TIE
        }
    }

    Shape getShapeForResult(Result result) {
        if (result == Result.WIN) {
            return new Rock()
        } else if (result == Result.TIE) {
            return new Paper()
        } else {
            return new Scissor()
        }
    }
}

class Scissor extends Shape {

    Scissor() {
        value = 3
        letters = ['C', 'Z']
    }

    Result resultOfBattling(Shape other) {
        if (other instanceof Rock) {
            return Result.LOSE
        } else if (other instanceof Paper) {
            return Result.WIN
        } else {
            return Result.TIE
        }
    }

    Shape getShapeForResult(Result result) {
        if (result == Result.WIN) {
            return new Paper()
        } else if (result == Result.TIE) {
            return new Scissor()
        } else {
            return new Rock()
        }
    }
}

List strategies = input.split '\n'

def partOne(List strategies) {
    int totalPoints = 0
    strategies.each { String strategy ->
        List shapeChoices = strategy.split(' ').collect { determineShape(it) }

        def opponents = shapeChoices.first()
        def yours = shapeChoices.last()
        totalPoints += yours.value + yours.resultOfBattling(opponents).value
    }

    println(totalPoints)
}

partOne(strategies)

def partTwo(List strategies) {
    int totalPoints = 0
    strategies.each { String strategy ->

        def opponents = determineShape(strategy.split(' ').first())
        def result = determineResult(strategy.split(' ').last())
        def yours = opponents.getShapeForResult(result)
        totalPoints += yours.value + yours.resultOfBattling(opponents).value
    }

    println(totalPoints)
}

partTwo(strategies)

Result determineResult(String input) {
    if (input == Result.WIN.letter) {
        return Result.WIN
    } else if (input == Result.TIE.letter) {
        return Result.TIE
    } else {
        return Result.LOSE
    }
}

Shape determineShape(String input) {
    Rock rock = new Rock()
    Paper paper = new Paper()
    Scissor scissor = new Scissor()

    if (rock.isShape(input)) {
        return rock
    } else if (paper.isShape(input)) {
        return paper
    } else {
        return scissor
    }
}
