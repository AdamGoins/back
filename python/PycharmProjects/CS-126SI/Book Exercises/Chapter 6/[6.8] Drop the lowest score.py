"""
Sometimes teachers will drop the lowest score in calculating a student's grade.

Write a function that removes the smallest value from a list and returns the result.
Hint: The list doesn't have to come back in the same order!

Test code:
print(remove_smallest([95, 92, 67, 85]))
print(remove_smallest([76, 81, 89, 67]))
print(remove_smallest([81, 75, 86, 89]))

Sample run:
[85, 92, 95]
[81, 76, 89]
[89, 81, 86]
"""

# Create a function that receives a list
def remove_smallest(my_list):

    my_list = sorted(my_list) # This sorts the list so that the lowest number is in the 0 index
    # Another solution my_list.sort() would be calling the sort METHOD of a list, rather than using the sorted function, but mutates the list object itself.

    del my_list[0] # 0 index is the lowest number because the list is sorted

    # Returns the list.
    return my_list

# Test code
print(remove_smallest([95, 92, 67, 85]))
print(remove_smallest([76, 81, 89, 67]))
print(remove_smallest([81, 75, 86, 89]))