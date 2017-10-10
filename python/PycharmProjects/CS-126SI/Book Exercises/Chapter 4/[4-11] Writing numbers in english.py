"""
The number 42 is written FORTY TWO.

Write a program that takes a two digit integer as input and then prints the written English form of the number.
Hint: You can get pretty far using modulo and if statements in this problem.

Sample run:

English Number Translator
=========================
Enter an integer: 22
TWENTY TWO
"""

"""
---THE SOLUTION---

To solve this problem, we will grab the int at the tens place and enter a condtional block
Based on what the int is. We'll append the english version of that tens place digit to the output string,
Then do the same with the ones place.
We'll then display output appropriately.
"""

number = int(input("Enter a two-digit integer: "))

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
        english_string += "FOURTH "
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

print(english_string)