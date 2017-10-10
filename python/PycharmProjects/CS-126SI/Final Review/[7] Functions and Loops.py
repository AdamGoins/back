""" What is the output of the following loops """

my_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
other_list = [1, "hey", 3, 4, 5, False, (1, 2, 3)]

def mystery(some_list):

    for element in some_list:
        print(element)

    print("Function is complete")

# What is the output:

#mystery(my_list)
#mystery(other_list)



# Convert the following for loop to a while loop:



# Convert the following while loop into a for loop


x = 50
while x > 0:
    print(x)
    x -= 5

for x in range(50, 0, -5):
    print(x)