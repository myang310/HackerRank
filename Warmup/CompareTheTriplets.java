/*
Alice and Bob each created one problem for HackerRank. A reviewer
rates the two challenges, awarding points on a scale from 1 to 100
for three categories: problem clarity, originality, and difficulty.

We define the rating for Alice's challenge to be the triplet
A = (a0, a1, a2), and the rating for Bob's challenge to be the
triplet B = (b0, b1, b2).

Your task is to find their comparison scores by comparing a0 with
b0, a1 with b1, and a2 with b2.

If ai > bi, then Alice is awarded 1 point.
If a1 < bi, then Bob is awarded 1 point.
If ai = bi, then neither person receives a point.
Given A and B, can you compare the two challenges and print their
respective comparison points?

Link: https://www.hackerrank.com/challenges/compare-the-triplets
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int a = 0;
        int b = 0;
        if (a0 > b0) a++;
        else if (b0 > a0) b++;
        if (a1 > b1) a++;
        else if (b1 > a1) b++;
        if (a2 > b2) a++;
        else if (b2 > a2) b++;

        System.out.println(a + " " + b);
    }
}
