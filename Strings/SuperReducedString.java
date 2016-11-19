/*
Steve has a string, s, consisting of n lowercase English
alphabetic letters. In one operation, he can delete any
pair of adjacent letters with same value. For example,
string "aabcc" would become either "aab" or "bcc" after
1 operation.

Steve wants to reduce s as much as possible. To do this,
he will repeat the above operation as many times as it
can be performed. Help Steve out by finding and printing
s's non-reducible form!

Note: If the final string is empty, print Empty String.

Link: https://www.hackerrank.com/challenges/reduced-string
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        str = reduceString(str);
        System.out.println(str);
    }

    public static String reduceString(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean canShorten = true;
        while (canShorten) {
            boolean shortened = false;
            for (int i = 0; i < sb.length()-1; i++) {
                if (sb.charAt(i) == sb.charAt(i+1)) {
                    sb.delete(i, i+2);
                    shortened = true;
                }
            }
            if (shortened)
                canShorten = true;
            else
                canShorten = false;
        }
        if (sb.length() == 0)
            return "Empty String";
        else
            return sb.toString();
    }
}
