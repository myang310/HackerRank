/*
A kidnapper wrote a ransom note but is worried it will be traced
back to him. He found a magazine and wants to know if he can cut
out whole words from it and use them to create an untraceable
replica of his ransom note. The words in his note are
case-sensitive and he must use whole words available in the
magazine, meaning he cannot use substrings or concatenation to
create the words he needs.

Given the words in the magazine and the words in the ransom
note, print Yes if he can replicate his ransom note exactly
using whole words from the magazine; otherwise, print No.

Link: https://www.hackerrank.com/challenges/ctci-ransom-note
*/

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        String[] magazineWords = magazine.split(" ");
        for (String word : magazineWords) {
            if (magazineMap.containsKey(word))
                magazineMap.put(word, magazineMap.get(word)+1);
            else
                magazineMap.put(word, 1);
        }

        String[] noteWords = note.split(" ");
        for (String word : noteWords) {
            if (noteMap.containsKey(word))
                noteMap.put(word, noteMap.get(word)+1);
            else
                noteMap.put(word, 1);
        }
    }

    public boolean solve() {
        Set<String> noteSet = noteMap.keySet();
        for (String word : noteSet){
            int numChecks = noteMap.get(word);
            for (int i = 0; i < numChecks; i++) {
                if (!magazineMap.containsKey(word))
                    return false;
                else {
                    int count = magazineMap.get(word);
                    count -= 1;
                    if (count != 0)
                        magazineMap.put(word, count);
                    else
                        magazineMap.remove(word);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
