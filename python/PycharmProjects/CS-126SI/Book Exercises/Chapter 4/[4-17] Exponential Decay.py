import math # We import math so we can use math.e in the decay formula

"""
Exponential decay is the decrease in quantity N according to the law N(t) = n0E^lambda(t) for a parameter t,
decay constant lambda, and initial value N(0) = N0. Write a program that takes in the half-life of substance in days, the initial amout in grams,
and a number of days.
Your program needs to calculate th edecay constant lambda and return how much is left of the initial amount of the substance after x number of days.

Sample run (the decay rate of plutonium):

Exponential Decay Calculator
============================
Decay rate (in days): 238
Initial amount (in grams): 100
Days: 30
The substance has a decay constant of -0.002912
After 30 days there is 91.6337 grams remaining.
"""

# First step is to get user input for the variables
half_life = float(input("Decay Rate (in days): "))
initial_amount = float(input("Initial Amount (in grams): "))
time = float(input("Days: "))

# Get the decay constant, formula is constant = 0.693 / half_life
decay_constant = 0.693 / half_life
print("The substance has a decay constant of:", decay_constant)

# Plug it all in to the formula
N = initial_amount * (math.e ** (-decay_constant * time))

print("After", time, " ays there is", N, "grams remaining.")