/*
Alice is taking a cryptography class and finding anagrams to be
very useful. We consider two strings to be anagrams of each other
if the first string's letters can be rearranged to form the second
string. In other words, both strings must contain the same exact
letters in the same exact frequency For example, bacdc and dcbac
are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings
where encryption is dependent on the minimum number of character
deletions required to make the two strings anagrams. Can you help
her find this number?

Given two strings, a and b, that may or may not be of the same
length, determine the minimum number of character deletions
required to make a and b anagrams. Any characters can be deleted
from either of the strings.

Link: https://www.hackerrank.com/challenges/ctci-making-anagrams
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        int numNeeded = 0;
        Map<Character, Integer> firstMap = createHashMap(first);

        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (firstMap.containsKey(c)) {
                int count = firstMap.get(c);
                count--;
                if (count == 0)
                    firstMap.remove(c);
                else
                    firstMap.put(c, count);
            }else {
                numNeeded++;
            }
        }
        Iterator it = firstMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            numNeeded += firstMap.get(entry.getKey());
        }

        return numNeeded;
    }

    private static Map<Character, Integer> createHashMap(String string) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
