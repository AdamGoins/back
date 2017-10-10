"""
Pain scales often use terms like "very mild" and "intense" to describe pain.

Write a function which uses a dictionary to translate human pain rating to a numerical score
no pain - 0
very mild - 1
discomforting - 2
tolerable - 3
distressing - 4
very distressing - 5
intense - 6
very intense - 7
utterly horrible - 8
unbearable - 9
unimaginable - 10

Test code:

print(translate_pain("very mild"))
print(translate_pain("intense"))
print(translate_pain("unbearable"))

Sample run:
1
6
9
"""

# Define a function that receives a string representing pain as a parameter
def translate_pain(pain):

    # Make it lower case for case insensitivity
    pain = pain.lower()

    # Create a dictionary that maps the pain to the pain level
    pain_dict = {"no pain": 0,
                 "very mild": 1,
                 "discomforting": 2,
                 "tolerable": 3,
                 "distressing": 4,
                 "very distressing": 5,
                 "intense": 6,
                 "very intense": 7,
                 "utterly horrible": 8,
                 "unbearable": 9,
                 "unimaginable": 10}

    # Returns the value associated with the key that is the pain felt
    return pain_dict[pain]


print(translate_pain("very mild"))
print(translate_pain("intense"))
print(translate_pain("unbearable"))