/*
James found a love letter his friend Harry has written for his girlfriend.
James is a prankster, so he decides to meddle with the letter. He changes
all the words in the letter into palindromes.

To do this, he follows two rules:

1. He can reduce the value of a letter, e.g. he can change d to c, but he
cannot change c to d.
2. In order to form a palindrome, if he has to repeatedly reduce the value
of a letter, he can do it until the letter becomes a. Once a letter has
been changed to a, it can no longer be changed.

Each reduction in the value of any letter is counted as a single operation.
Find the minimum number of operations required to convert a given string
into a palindrome.

Link: https://www.hackerrank.com/challenges/the-love-letter-mystery
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        int m;
        for (int i = 0; i < tests; i++)
            System.out.println(minOperations(s.next()));
    }

    public static int minOperations(String str) {
        int operations = 0;
        for (int i = 0; i < str.length()/2; i++) {
            int left = (int)str.charAt(i);
            int right = (int)str.charAt(str.length()-i-1);
            operations += Math.abs(left - right);
        }
        return operations;
    }
}
