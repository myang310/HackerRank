# Alice is playing an arcade game and wants to climb to the top of the 
# leaderboard and wants to track her ranking. The game uses Dense Ranking, 
# so its leaderboard works like this:
#
# The player with the highest score is ranked number 1 on the leaderboard.
# Players who have equal scores receive the same ranking number, and the 
# next player(s) receive the immediately following ranking number.
# For example, the four players on the leaderboard have high scores of 100,
# 90, 90, and 80. Those players will have ranks 1, 2, 2, and 3, respectively.
# If Alice's scores are 70, 80 and 105, her rankings after each game are 4, 3 
# and 1.
#
# Link: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    ranks = []
    prev = math.inf
    rank = 0
    for i in range(0, len(scores)):
        if scores[i] != prev:
            rank += 1
            prev = scores[i]
        ranks.append(rank)
    ranks.append(rank+1)

    current_end = len(scores)-1
    alice_ranks = []
    for i in range(0, len(alice)):
        rank_index = traverse_bst(scores, 0, current_end, alice[i])
        current_end = min(len(scores)-1, rank_index)
        alice_ranks.append(ranks[rank_index])

    return alice_ranks

def traverse_bst(scores, start, end, goal):
    # print (start, end)
    mid = (start + end) // 2
    if scores[mid] == goal:
        return mid
    elif scores[mid] < goal:
        if mid-1 < start:
            return mid
        else:
            return traverse_bst(scores, start, mid-1, goal)
    elif scores[mid] > goal:
        if mid+1 > end:
            return mid + 1
        else:
            return traverse_bst(scores, mid+1, end, goal)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

