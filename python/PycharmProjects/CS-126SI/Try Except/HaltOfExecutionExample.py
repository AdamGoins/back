

def add_two_numbers(number_one, number_two):

    if isinstance(number_one, int) and isinstance(number_two, int):
        sum = number_one + number_two
        print("The sum of the two numbers is:", sum)

    else:
        print("Please enter integers")

    print("Function Completed")
add_two_numbers(1, 18)
add_two_numbers(1, "18")

"""-------------EXERCISE------------"""
"""Handle that problem such that it accounts for invalid input using Try / Except AND Look before you leap"""
