"""
Wind Chill describes the rate of heat loss on the human body based on the combined effect of temperature (Y) and wind (V)
The national Weather Service defines Wind Chill Index as T(wc) = 35.74 + 0.62157T - 35.75(V^0.16) + 0.42757T(V^0.16),
Where T and V are given in Fahrenheit and Miles Per Hour respectively.

Write a program that computes the wind chill.

Sample run:

Wind Chill Calculator
=====================
Enter temperature (F): 40
Enter wind speed (mph): 30
The wind chill is 28.462045104487707
"""

temp = float(input("Enter temperature (F): "))
wind_speed = float(input("Enter wind speed (mph): "))

# Plug the values into the wind chill formula
wind_chill = 35.74 + (0.6215 * temp) - 35.75 * (wind_speed ** 0.16) + (0.4275 * temp * wind_speed ** 0.16)

print("The wind chill is", wind_chill)