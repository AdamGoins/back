"""
Write a function that takes SMS shorthand as an argument and returns the expansion of that shorthand.
Use a dictionary to map shorthand to their full meaning. If you can't find a term, return the original string.
Your function should handle terms in a case insensitive way. You can find a list of common SMS phrases in Wikipedias article on SMS language
URL: https://en.wikipedia.org/wiki/SMS_language

Test code:

print(sms_expander("AFAIK"))
print(sms_expander("BTW"))
print(sms_expander("rotfl"))
print(sms_expander("YOWZERS"))

Sample run:

as far as I know
by the way
rolling on the floor laughing
YOWZERS
"""

# Define a function that receives the word to expand as an argument
def sms_expander(word):
    # Make word lower case to be case insensitive
    word = word.lower()

    # Create a dictionary that maps like 5 textese words
    # The key to the dictionary is the shorthand, the value is the longhand. All keys are lower case for case insensitivity
    word_dict = {"afaik": "As far as I know",
                 "btw": "By the way",
                 "rotfl": "Rolling on the floor laughing",
                 "lol": "Laugh out loud",
                 "omg": "Oh my gosh"}

    # If the word received is a key in the dictionary, get the value (longhand) and return it.
    if word in word_dict.keys():
        # Gets the value from the dictionary by the key
        return word_dict[word]
    # Otherwise we just return the word
    else:
        return word

    # Refactored solution using a turnary
    # return word_dict[word] if word in word_dict.keys() else word

print(sms_expander("AFAIK"))
print(sms_expander("BTW"))
print(sms_expander("rotfl"))
print(sms_expander("YOWZERS"))
