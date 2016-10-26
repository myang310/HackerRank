/*
Your algorithms have become so good at predicting the market
that you now know what the share price of Wooden Orange
Toothpicks Inc. (WOT) will be for the next N days.

Each day, you can either buy one share of WOT, sell any number
of shares of WOT that you own, or not make any transaction at
all. What is the maximum profit you can obtain with an optimum
trading strategy?

Link: https://www.hackerrank.com/challenges/stockmax
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTests = s.nextInt();

        for (int test = 0; test < numTests; test++) {
            int totalDays = s.nextInt();
            long[] prices = new long[totalDays];
            for (int day = 0; day < totalDays; day++)
                prices[day] = s.nextLong();

            long profit = computeMaxProfit(prices);
            System.out.println(profit);
        }
    }
    public static long computeMaxProfit(long[] prices) {
        int today = prices.length - 1;
        long currentMaxPrice = prices[today];
        long maxProfit = 0;

        for (today -= 1; today >= 0; today--) {
            if (prices[today] > currentMaxPrice)
                currentMaxPrice = prices[today];
            else {
                maxProfit += (currentMaxPrice - prices[today]);
            }
        }

        return maxProfit;
    }
}
