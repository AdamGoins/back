"""
    Adam Goins
    CS126 SI
    Chapter 5
    Functions and Arguments
"""








def main():
    homework_points_acquired = [7, 5, 3]
    homework_points_total = [10, 10, 10]

    homework_total = addPoints(homework_points_acquired)
    homework_overall = addTotal(homework_points_total)

    quiz_points_acquired = [7, 5, 3]
    quiz_points_total = [10, 10, 10]

    totalPoints = addPoints(quiz_points_acquired)
    overallPoints = addTotal(quiz_points_total)

    homeWork_contribute = getClassContribution(homework_total, homework_overall, .2)
    quiz_contribute = getClassContribution(totalPoints, overallPoints, .5)
    print("Homework total", homeWork_contribute)
    print("Quz total", quiz_contribute)


    test_scores = [50, 70, 100]
    test_total = [100, 100, 100]


def getClassContribution(total, overall, weight):
    return ((total / overall) * 100) * weight

def addPoints(list):
    return sum(list)

def addTotal(list):
    return sum(list)

main()











