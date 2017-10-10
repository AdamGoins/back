"""
In question 3-7 we covered converting Fahrenheit to Celsius. This time implement a temperature conversion function
that takes in a temperature, whether it is fahrenheit, celsius, or kevlin, and what to convert it to.
Return your results formatted to 1 decimal place

Test code:
print(temp_conversion(90, "F", "C"))
print(temp_conversion(-4, "C", "F"))
print(temp_conversion(10, "C", "K"))

SAmple run:
32.2
24.8
283.0
"""

# Define a function with appropriate parameters

def temp_conversion(temp, current_type, desired_type):

    # For this solution we're going to convert whatever temp type is given to fahrenheit, then do the approrpiate convesion
    # To the desired type from there
    if current_type == "F":
        # If it's already Fahrenheit, we don't need to do anything.
        fahrenheit = temp


    elif current_type == "C":
        # Convert Celsius to Fahrehnheit
        temp = (temp * (9.0 / 5.0)) + 32

    elif current_type == "K":
        # Convert Kelvin to Fahrenheit
        temp = (temp * (9/5)) - 459.67



    else:
        return "Invalid temperature type given."

# This function is designed to turn degrees in fahrenheit to degrees in celsius
def fahrenheit_to_celius(f):
    return (f - 32) * (5.0/9.0)

def celsius_to_fahrenheit(c):
    return (c * (9.0/5.0))