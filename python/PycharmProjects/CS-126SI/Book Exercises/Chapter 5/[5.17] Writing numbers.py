"""
In exercise 4-11 we wrote numbers out as english.
This time define a function that takes in a two digit number and returns the number wtirren in English.
For simplicity your program only needs to handle the number range 0-99

Test code:
print(convert_to_english(5))
print(convert_to_english(20))
print(convert_to_english(35))

Sample run:

Five
Twenty
Thirty-Five
"""

# We're just going to use the code from exercise 4-11 and put it in a function.

def convert_to_english(number):

    """
    ---THE SOLUTION---

    To solve this problem, we will grab the int at the tens place and enter a condtional block
    Based on what the int is. We'll append the english version of that tens place digit to the output string,
    Then do the same with the ones place.
    We'll then return the string
    """

    # Grabs the tens digit
    tens = number // 10
    # Grabs the ones digit
    ones = number % 10

    english_string = ""
    if tens == 1:
        if ones == 0:
            english_string += "TEN"
        elif ones == 1:
            english_string += "ELEVEN"
        elif ones == 2:
            english_string += "TWELVE"
        elif ones == 3:
            english_string += "THIRTEEN"
        elif ones == 4:
            english_string += "FOURTEEN"
        elif ones == 5:
            english_string += "FIFTEEN"
        elif ones == 6:
            english_string += "SIXTEEN"
        elif ones == 7:
            english_string += "SEVENTEEN"
        elif ones == 8:
            english_string += "EIGHTEEN"
        elif ones == 9:
            english_string += "NINETEEN"
        else:
            english_string += "INVALID"

    else:
        if tens == 2:
            english_string += "TWENTY "
        elif tens == 3:
            english_string += "THIRTY "
        elif tens == 4:
            english_string += "FOURTY "
        elif tens == 5:
            english_string += "FIFTY "
        elif tens == 6:
            english_string += "SIXTY "
        elif tens == 7:
            english_string += "SEVENTY "
        elif tens == 8:
            english_string += "EIGHTY "
        elif tens == 9:
            english_string += "NINETY "

        if ones == 1:
            english_string += "ONE"
        elif ones == 2:
            english_string += "TWO"
        elif ones == 3:
            english_string += "THREE"
        elif ones == 4:
            english_string += "FOUR"
        elif ones == 5:
            english_string += "FIVE"
        elif ones == 6:
            english_string += "SIX"
        elif ones == 7:
            english_string += "SEVEN"
        elif ones == 8:
            english_string += "EIGHT"
        elif ones == 9:
            english_string += "NINE"

        return english_string

# Test code

print(convert_to_english(5))
print(convert_to_english(20))
print(convert_to_english(35))
