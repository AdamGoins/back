"""
Create a function which takes a number from 0-99 and returns the corresponding roman numeral (See problem 3-1).
Think about how individual digits contribute to the numeral and how you might <b>map</b> Arabic decimals to their Roman counterparts,
If your Roman numeral composition skills are rusty, you might consult Wikipedia's article on Roman Numerals
URL: https://en.wikipedia.org/wiki/Roman_numerals

Test code:
print(roman(7))
print(roman(17))
print(roman(77))

Sample run:
VII
XVII
LXXVII
"""

# Define our function that receives a number to convert
def roman(number):
    # We know it's a number between 0 - 99, so let's parse each digit and get it's romanized form with respect to it's position (ones, tens, etc).

    # Get digit in ones place
    ones = number % 10
    # Get the digit in the tens place
    tens = number // 10

    # The problem statement gave us a hint to the desired solution, the word "maps" was used.
    # This tells use that we should use a dictionary to map keys (the digit) to the value (romanized digit) and return that approrpiately.
    # To do this we'll create two dictionaries, one to represent the romanized version of numbers in the ones place,
    # The other to represent romanized versions of numbers in the tens places

    ones_dict = {
        0 : "",
        1: "I",
        2: "II",
        3: "III",
        4: "IV",
        5: "V",
        6: "VI",
        7: "VII",
        8: "VIII",
        9: "IX"
    }

    tens_dict = {
        0: "",
        1: "X",
        2: "XX",
        3: "XXX",
        4: "IL",
        5: "L",
        6: "LX",
        7: "LXX",
        8: "LXXX",
        9: "XC"
    }

    # Lastly, we concat the tens roman number with the ones roman number to get the final result and return it
    romanized_number = tens_dict[tens] + ones_dict[ones]
    return romanized_number

# Test code
print(roman(7))
print(roman(17))
print(roman(77))