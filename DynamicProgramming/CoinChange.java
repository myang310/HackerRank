/*
How many different ways can you make change for an amount,
given a list of coins? In this problem, your code will need
to efficiently compute the answer.

Task: Write a program that, given
1. The amount N to make change for and the number of types M
of infinitely available coins
A list of M coins - C = {C1, C2, C3,.., CM}
Prints out how many different ways you can make change from the
coins to STDOUT.

The problem can be formally stated:

Given a value N, if we want to make change for N cents, and we
have infinite supply of each of C = {C1, C2, C3,.., CM} valued
coins, how many ways can we make the change? The order of coins
doesn’t matter.

Solving the overlapping subproblems using dynamic programming

You can solve this problem recursively, but not all the tests
will pass unless you optimise your solution to eliminate the
overlapping subproblems using a dynamic programming solution

Or more specifically;

If you can think of a way to store the checked solutions, then
this store can be used to avoid checking the same solution again
and again.

Link: https://www.hackerrank.com/challenges/coin-change
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = input.nextInt();
        int numUnique = input.nextInt();
        int[] coins = new int[numUnique];

        for (int i = 0; i < numUnique; i++)
            coins[i] = input.nextInt();

        System.out.println(waysForChange(total, coins));
    }

    private static long waysForChange(int total, int[] coins) {
        int N = coins.length;
        long[][] count = new long[total+1][N];
        for (int i = 0; i <= total; i++)
            Arrays.fill(count[i], -1);
        count[0][0] = 1;

        countWays(total, N-1, coins, count);

        return count[total][N-1];
    }

    private static long countWays(int target, int index, int[] coins, long[][] counts) {
        if (index < 0)
            return 0;
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;

        if (counts[target][index] != -1)
            return counts[target][index];

        counts[target][index] = countWays(target, index-1, coins, counts) +
            countWays(target-coins[index], index, coins, counts);

        return counts[target][index];
    }
}
