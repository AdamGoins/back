

"""
" Write a function that accepts two integer arguments and returns the sum of those two arguments
" Call the function using arbitrary values and display the appropriate output
"""

someNumber = 6


def add_numbers(n1, n2):
    sum_of_numbers = n1 + n2
    return sum_of_numbers

def sub_num(n1,n2):
    subtraction = n2 - n1
    return subtraction

def main():
    points_acquired = []
    points_total = [20]

    homework_score_one = int(input("Enter your first homework score:"))
    points_acquired.append(homework_score_one)

    homework_weighted_percent = get_total_percent(points_acquired, points_total, .2)
    print(homework_weighted_percent)


    test_points_acquired = [50, 75, 100]
    test_points_total = [100, 100, 100]

    test_weighted_percent = get_total_percent(test_points_acquired, test_points_total, .5)
    print("weighted test percent: ", test_weighted_percent)

def get_total_percent(points_acquired, points_total, weight):

    total_points_acquired = sum(points_acquired)
    total_points_overall = sum(points_total)
    percent_total = (total_points_acquired / total_points_overall) * 100
    weighted_percent = percent_total * weight
    return weighted_percent




main()





































""" What is the output of these functions? """

def sayHi():
    print("Hi!")

# sayHi()



def saySomething(something):
    print(something)

# saySomething("This is something meaningful to say")


""" Now lets add returns statements """



def roundMyNumber(number, place_to_round_to):
    return round(number, place_to_round_to)
    print("Your number is rounded!")

# roundMyNumber(1.6180339887498948482045868345, 5)
