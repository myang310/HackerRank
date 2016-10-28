/*
John's clothing store has a pile of n loose socks where each
sock i is labeled with an integer, ci, denoting its color. He
wants to sell as many socks as possible, but his customers
will only buy them in matching pairs. Two socks,i and j, are
a single matching pair if ci = cj.

Given n and the color of each sock, how many pairs of socks
can John sell?

Link: https://www.hackerrank.com/challenges/sock-merchant
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        int pairs = 0;
        for(int c_i=0; c_i < n; c_i++){
            int color = in.nextInt();
            if (set.contains(color)) {
                pairs++;
                set.remove(color);
            }else {
                set.add(color);
            }
        }

        System.out.println(pairs);
    }
}
