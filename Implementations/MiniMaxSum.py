# Given five positive integers, find the minimum and maximum 
# values that can be calculated by summing exactly four of 
# the five integers. Then print the respective minimum and 
# maximum values as a single line of two space-separated long 
# integers.
#
# For example, arr = [1,3,5,7,9]. Our minimum sum is 1+3+5+7=16 
# and our maximum sum is 3+5+7+9=24. We would print
# 16 24
#
# Link: https://www.hackerrank.com/challenges/mini-max-sum/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the miniMaxSum function below.
def miniMaxSum(arr):
    min_value = math.inf
    max_value = -math.inf
    sum = 0

    for number in arr:
        sum += number
        min_value = min(min_value, number)
        max_value = max(max_value, number)

    print(sum - max_value, sum - min_value)

if __name__ == '__main__':
    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)

