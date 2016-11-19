/*
Alice is a kindergarden teacher. She wants to give some
candies to the children in her class. All the children
sit in a line (their positions are fixed), and each of
them has a rating score according to his or her
performance in the class.  Alice wants to give at least
1 candy to each child. If two children sit next to each
other, then the one with the higher rating must get more
candies. Alice wants to save money, so she needs to
minimize the total number of candies given to the children.

Link: https://www.hackerrank.com/challenges/candies
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numChildren = s.nextInt();
        int[] ratings = new int[numChildren];
        for (int i = 0; i < numChildren; i++) {
            ratings[i] = s.nextInt();
        }

        long candies = solveMinCandies(ratings);
        System.out.println(candies);
    }

    public static long solveMinCandies(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 0);
        candy[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (candy[i] != 0)
                continue;
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }else if (ratings[i] < ratings[i-1]) {
                findMinCandy(ratings, candy, i-1);
            }else {
                candy[i] = 1;
            }
        }
        return sum(candy);
    }

    private static int findMinCandy(int[] rating, int[] candy, int index) {
        if (index >= rating.length)
            return 0;

        if (index == rating.length-1) {
            candy[index] = 1;
        }else if (rating[index] > rating[index+1]) {
            int newCount = 1 + findMinCandy(rating, candy, index+1);
            candy[index] = Math.max(candy[index], newCount);
        }else {
            candy[index] = 1;
        }
        return candy[index];
    }

    private static long sum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
