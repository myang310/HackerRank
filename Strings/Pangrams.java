/*
Roy wanted to increase his typing speed for programming contests.
So, his friend advised him to type the sentence "The quick brown
fox jumps over the lazy dog" repeatedly, because it is a pangram.
(Pangrams are sentences constructed by using every letter of the
alphabet at least once.)

After typing the sentence several times, Roy became bored with
it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Link: https://www.hackerrank.com/challenges/pangrams
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        boolean pangram = isPangram(str);
        if (pangram)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }

    public static boolean isPangram(String str) {
        Set<Character> set = alphabetSet();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (set.contains(c))
                set.remove(c);
        }
        if (set.isEmpty())
            return true;
        else
            return false;
    }

    public static Set<Character> alphabetSet() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < alphabet.length; i++)
            set.add(alphabet[i]);
        return set;
    }
}
