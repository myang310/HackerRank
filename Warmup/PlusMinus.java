/*
Given an array of integers, calculate which fraction of
its elements are positive, which fraction of its elements
are negative, and which fraction of its elements are zeroes,
respectively. Print the decimal value of each fraction on
a new line.

Note: This challenge introduces precision problems. The test
cases are scaled to six decimal places, though answers with
absolute error of up to 10^-4 are acceptable.

Link: https://www.hackerrank.com/challenges/plus-minus
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        printPlusNeg(s, count);
    }

    public static void printPlusNegZero(Scanner s, int count) {
        int neg = 0;
        int pos = 0;
        int zero = 0;
        for (int i = 0; i < count; i++) {
            int num = s.nextInt();
            if (num == 0)
                zero++;
            else if (num > 0)
                pos++;
            else if (num < 0)
                neg++;
        }

        System.out.println((double)pos/count);
        System.out.println((double)neg/count);
        System.out.println((double)zero/count);
    }
}
