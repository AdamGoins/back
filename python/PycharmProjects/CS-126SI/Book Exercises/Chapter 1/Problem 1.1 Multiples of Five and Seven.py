"""
---Problem Statement---
If we list all of the positive integers below 20 that are multiples of 5 and
7 we get 5, 7, 10, 14, and 15. The sum of these numbers is 51. Find the
sum of the multiples of 5 and 7 below 100.
"""

"""---Solution---"""

"""We can get a solution by getting every multiple 'm' of 5 and 7 such 0 < m <= 100"""

# Grabbing multiples of 5
five_multiple_one = 5 * 1 # Answer is 5, which is <= 100. This logic will be applied to all following 5 multiples.
five_multiple_two = 5 * 2 # 10
five_multiple_three = 5 * 3 # 15
five_multiple_four = 5 * 4 # 20
