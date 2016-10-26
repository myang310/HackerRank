/*
Each time Sunny and Johnny take a trip to the Ice Cream Parlor,
they pool together m dollars for ice cream. On any given day,
the parlor offers a line of n flavors. Each flavor, i, is
numbered sequentially with a unique ID number from 1 to n and
has a cost, ci, associated with it.

Given the value of m and the cost of each flavor for t trips to
the Ice Cream Parlor, help Sunny and Johnny choose two flavors
such that they spend their entire pool of money (m) during each
visit. For each trip to the parlor, print the ID numbers for the
two types of ice cream that Sunny and Johnny purchase as two
space-separated integers on a new line. You must print the
smaller ID first and the larger ID second.

Note: Two ice creams having unique IDs i and j may have the
same cost (i.e., c1 == c2).

Link: https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if (map.containsKey(a[a_i])) {
                    List<Integer> list = map.remove(a[a_i]);
                    list.add(a_i);
                    map.put(a[a_i], list);
                }else {
                    List<Integer> list = new ArrayList<Integer>();;
                    list.add(a_i);
                    map.put(a[a_i], list);
                }
            }
            Arrays.sort(a);

            printTwoIds(a, map, m);
        }
    }

    private static void printTwoIds(int[] a, HashMap<Integer, List<Integer>> map, int target) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int diff = target - a[i];
            if (map.containsKey(diff)) {
                int firstId = map.get(a[i]).get(0) + 1;
                int secondId;
                if (a[i] == diff)
                    secondId = map.get(a[i]).get(1) + 1;
                else
                    secondId = map.get(diff).get(0) + 1;
                if (firstId < secondId)
                    System.out.println(firstId + " " + secondId);
                else
                    System.out.println(secondId + " " + firstId);
                return;
            }
        }
    }
}
