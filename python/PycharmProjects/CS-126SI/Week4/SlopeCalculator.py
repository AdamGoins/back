def slope(x1, y1, b1):

    m = (y1 - b1) / x1
    return m

x = float(input("Input an X value: "))
y = float(input("Input a Y value: "))
b = float(input("Input a Y-Intercept: "))

print("Slope is: ", slope(x, y, b))
print("Slope is: ", slope(5, 2, 10))