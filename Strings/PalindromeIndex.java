/*
Given a string, S, of lowercase letters, determine the index of the character
whose removal will make S a palindrome. If S is already a palindrome or no such
character exists, then print -1. There will always be a valid solution, and any
correct answer is acceptable. For example, if S = "bcbc", we can either remove
'b' at index 0 or 'c' at index 3.

Link: https://www.hackerrank.com/challenges/palindrome-index
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        for (int i = 0; i < tests; i++) {
            String input = s.next();
            int index = indexForPalindrome(input);
            System.out.println(index);
        }
    }

    private static int indexForPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                if (str.charAt(i + 1) == str.charAt(str.length() - i - 1)) {
                    if (str.charAt(i + 2) == str.charAt(str.length() - i - 2))
                        return i;
                    else
                        return str.length() - i - 1;
                }else {
                    if (str.charAt(i + 1) == str.charAt(str.length() - i - 3))
                        return str.length() - i - 1;
                    else
                        return i;
                }
            }
        }

        return -1;
    }
}
