/*
A left rotation operation on an array of size n shifts each
of the array's elements 1 unit to the left. For example, if 2
left rotations are performed on array [1, 2, 3, 4, 5], then
the array would become [3, 4, 5, 1, 2].

Given an array of n integers and a number, d, perform d left
rotations on the array. Then print the updated array as a
single line of space-separated integers.

Link: https://www.hackerrank.com/challenges/ctci-array-left-rotation
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int d) {
        int[] copy = new int[n];
        for (int i = 0; i < n; i++)
            copy[i] = a[(i+d)%n];
        return copy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, d);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
