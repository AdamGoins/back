"""
Body Mass Index (BMI) is a number calculated from a person's weight and height.
BMI does not measure fat directly, but research has shown that BMI correlates to direct measures of body fat.
The BMI formula is weight in pounds divided by height in inches squared and multiplied by 703.

Sample run:

Body Mass Index Calculator
==========================
Enter weight (pounds): 145
Enter height (inches): 70
Your BMI is 20.803061224489795
"""

weight = float(input("Enter weight (pounds): "))
height = float(input("Enter height (inches): "))

# Plug the variables into the BMI formula to get the BMI
BMI = weight / (height ** 2) * 703

print("Your BMI is", BMI)