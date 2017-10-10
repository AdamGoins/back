magic_square = [[11, 18, 25, 2, 9],
                [10, 12, 19, 21, 3],
                [4, 6, 13, 20, 22],
                [23, 5, 7, 14, 16],
                [17, 24, 1, 8, 15]]


# calculate sum of rows
size = len(magic_square)
row_sum = []
for row in magic_square:
    row_sum.append(sum(row))
print(row_sum)

# calculate sum of columns
col_sum = []
for col in range(size):
    for row in magic_square:
        col_sum.append(sum(row[col]))
print(col_sum)
