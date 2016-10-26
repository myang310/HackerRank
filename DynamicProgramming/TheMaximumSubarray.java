/*
Given an array A={a1,a2,...,an} of N elements, find the maximum
possible sum of a:
1. Contiguous subarray
2. Non-contiguous (not necessarily contiguous) subarray.

Empty subarrays/subsequences should not be considered.
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numTests = input.nextInt();
        for (int i = 0; i < numTests; i++) {
            int arrSize = input.nextInt();
            int[] arr = new int[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = input.nextInt();
            }

            System.out.println(maxContig(arr) + " " + maxNotContig(arr));
        }
    }

    private static int maxContig(int[] arr) {
        int currentMax = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            overallMax = Math.max(currentMax, overallMax);
        }

        return overallMax;
    }

    private static int maxNotContig(int[] arr) {
        int max = arr[0];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }

        if (sum == 0)   return max;
        else            return sum;
    }
}
