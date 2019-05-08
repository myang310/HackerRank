# Madison is a little girl who is fond of toys. Her friend Mason works in a
# toy manufacturing factory. Mason has a 2D board A of size H x W with H rows
# and W columns. The board is divided into cells of size 1 x 1 with each cell 
# indicated by its coordinate (i,j). The cell (i,j) has an integer Aij written
# on it. To create the toy Mason stacks Aij number of cubes of size 1 x 1 x 1
# on cell (i,j).
# Given the description of the board showing the values of Aij and that the
# price of the toy is equal to the 3d surface area, find the price of the toy.
#
# Link: https://www.hackerrank.com/challenges/3d-surface-area/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the surfaceArea function below.
def surfaceArea(A):
    height = len(A)
    width = len(A[0])

    surfaceArea = 2 * height * width

    for i in range(height):
        prev = 0
        area = 0
        for j in range(width):
            current_value = A[i][j]
            if current_value > prev:
                area += abs(current_value - prev)
            prev = current_value
        
        surfaceArea += area * 2

    for i in range(width):
        prev = 0
        area = 0
        for j in range(height):
            current_value = A[j][i]
            if current_value > prev:
                area += abs(current_value - prev)
            prev = current_value
        
        surfaceArea += area * 2
    
    return surfaceArea

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    HW = input().split()

    H = int(HW[0])

    W = int(HW[1])

    A = []

    for _ in range(H):
        A.append(list(map(int, input().rstrip().split())))

    result = surfaceArea(A)

    fptr.write(str(result) + '\n')

    fptr.close()

