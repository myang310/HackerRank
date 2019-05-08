# Given a set of distinct integers, print the size of a maximal 
# subset of S where the sum of any 2 numbers in S" is not evenly
# divisible by k.
#
# For example, the array S = [19, 10, 12, 10, 24, 25, 22] and k = 4.
# One of the arrays that can be created is S"[0] = [10, 12, 25]. 
# Another is S"[1] = [19, 22, 24]. After testing all permutations, 
# the maximum length solution array has elements.
#
# Link: https://www.hackerrank.com/challenges/non-divisible-subset/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the nonDivisibleSubset function below.
def nonDivisibleSubset(k, S):
    dict = {}
    for value in S:
        remainder = value % k
        if remainder in dict:
            dict[remainder] = dict[remainder] + 1
        else:
            dict[remainder] = 1

    largestSubset = 0

    if (k % 2 == 0):
        end = k/2 - 1
        if (dict.get(k/2)):
            largestSubset += 1
    else:
        end = k/2

    for value in range(1, int(end) + 1):
        compValue = k - value
        if dict.get(value) and dict.get(compValue):
            largestSubset += max(dict[value], dict[compValue])
        elif dict.get(value):
            largestSubset += dict[value]
        elif dict.get(k - value):
            largestSubset += dict[compValue]

    if (dict.get(0)):
        largestSubset += 1

    return largestSubset

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    S = list(map(int, input().rstrip().split()))

    result = nonDivisibleSubset(k, S)

    fptr.write(str(result) + '\n')

    fptr.close()

