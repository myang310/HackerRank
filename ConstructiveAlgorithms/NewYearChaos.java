/*
It's New Year's Day and everyone's in line for the Wonderland
rollercoaster ride!

There are n people queued up, and each person wears a sticker
indicating their initial position in the queue
(i.e.: 1,2,...,n-1, n with the first number denoting the
frontmost position).

Any person in the queue can bribe the person directly in
front of them to swap positions. If two people swap positions,
they still wear the same sticker denoting their original
place in line. One person can bribe at most two other persons.

That is to say, if n = 8 and Person 5 bribes Person 4, the
queue will look like this: 1,2,3,5,4,6,7,8.

Fascinated by this chaotic queue, you decide you must know
the minimum number of bribes that took place to get the queue
into its current state!

Note: Each Person X wears sticker X, meaning they were
initially the Xth person in queue.

Link: https://www.hackerrank.com/challenges/new-year-chaos
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();

        for (int i = 0; i < tests; i++) {
            int num = s.nextInt();
            int[] queue = new int[num];
            for (int j = 0; j < num; j++) {
                queue[j] = s.nextInt();
            }

            int bribes = getMinBribes(queue);
            if (bribes != -1)
                System.out.println(bribes);
            else
                System.out.println("Too chaotic");
        }
    }

    public static int getMinBribes(int[] result) {
        int bribes = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= result.length; i++) {
            queue.add(i);
        }
        for (int i = 0; i < result.length; i++) {
            int diff = queue.indexOf(result[i]);
            if (diff == 0) {
                queue.removeFirst();
            }else if (diff > 2) {
                return -1;
            }else {
                bribes += diff;
                queue.remove(new Integer(result[i]));
            }
        }
        return bribes;
    }
}
