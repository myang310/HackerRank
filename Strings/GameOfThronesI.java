/*
Dothraki are planning an attack to usurp King Robert's throne. King Robert
learns of this conspiracy from Raven and plans to lock the single door through
which the enemy can enter his kingdom. But, to lock the door he needs a key
that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure
out whether any anagram of the string can be a palindrome or not.

Link: https://www.hackerrank.com/challenges/game-of-thrones
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        if (canBePalindrome(str))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static boolean canBePalindrome(String str) {
        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }

        if (set.size() > 1)
            return false;

        return true;
    }
}
