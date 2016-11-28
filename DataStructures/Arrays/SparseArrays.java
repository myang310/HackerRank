/*
There are N strings. Each string's length is no more than
20 characters. There are also Q queries. For each query, you
are given a string, and you need to find out how many times
this string occurred previously.

Link: https://www.hackerrank.com/challenges/sparse-arrays
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // Not an arrays solution; used hash map for efficiency
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            String input = s.next();
            if (map.containsKey(input)) {
                map.put(input, map.get(input)+1);
            }else {
                map.put(input, 1);
            }
        }
        count = s.nextInt();
        for (int i = 0; i < count; i++) {
            String query = s.next();
            System.out.println( map.containsKey(query) ? map.get(query) : 0 );
        }
    }
}
