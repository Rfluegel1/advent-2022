List calories = input.split '\n'

def problemOne(List calories) {
    int largestCalorieTotal = -1
    int runningTotal = 0

    calories.each { calorie ->
        if (calorie == '') {
            if (runningTotal > largestCalorieTotal) {
                largestCalorieTotal = runningTotal
            }
            runningTotal = 0
        } else {
            runningTotal += (calorie as int)
        }
    }

    println(largestCalorieTotal)
}

problemOne(calories)

def problemTwo(List calories) {
    int runningTotal = 0
    List groupedCalories = []

    calories.each { calorie ->
        if (calorie == '') {
            groupedCalories << runningTotal
            runningTotal = 0
        } else {
            runningTotal += (calorie as int)
        }
    }

    println(groupedCalories.sort().reverse()[0..2].sum())
}

problemTwo(calories)
