/*
Julius Caesar protected his confidential information
by encrypting it in a cipher. Caesar's cipher rotated
every letter in a string by a fixed number, K, making
it unreadable by his enemies. Given a string, S, and
a number, K, encrypt S and print the resulting string.

Note: The cipher only encrypts letters; symbols, such
as -, remain unencrypted.

Link: https://www.hackerrank.com/challenges/caesar-cipher-1
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
        String s = in.next();
        int k = in.nextInt();

        String code = cipher(s, k);
        System.out.println(code);
    }

    public static String cipher(String str, int k) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                int value = (int) c;
                value -= 65;
                value = (value + k) % 26;
                sb.setCharAt(i, (char)(value + 65));
            }else if (Character.isLetter(c) && Character.isLowerCase(c)) {
                int value = (int) c;
                value -= 97;
                value = (value + k) % 26;
                sb.setCharAt(i, (char)(value + 97));
            }
        }
        return sb.toString();
    }
}
