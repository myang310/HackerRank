/*
Here's a humerus joke:

Why did Papyrus the skeleton go to the store by himself? Because
he had no body to go with him!

Did you like it? Don't worry, I've got a ton more. A skele-ton.

Once upon a time, Papyrus the skeleton went to buy some pasta
from the store. The store's inventory is bare-bones and they
only sell one thing — boxes of uncooked spaghetti! The store
always stocks exactly k boxes of pasta, and each box is numbered
sequentially from 1 to k. This box number also corresponds to the
number of sticks of spaghetti in the box, meaning the first box
contains 1 stick, the second box contains 2 sticks, the third box
contains 3 sticks, …, and the kth box contains k sticks. Because
they only stock one box of each kind, the store has a tendon-cy
to sell out of spaghetti.

During each trip to the store, Papyrus likes to buy exactly n
sticks of spaghetti by purchasing exactly  boxes (no more, no
less). Not sure which boxes to purchase, Papyrus calls Sherlock
Bones for help but he's also stumped! Do you have the guts to
solve this puzzle?

Given the values of n, k, and b for t trips to the store,
determine which boxes Papyrus must purchase during each trip.
For each trip, print a single line of b distinct space-separated
integers denoting the box number for each box of spaghetti
Papyrus purchases (recall that the store only has one box of
each kind). If it's not possible to buy n sticks of spaghetti
by purchasing b boxes, print -1 instead.

Link: https://www.hackerrank.com/challenges/bonetrousle
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int trips = s.nextInt();
        for (int i = 0; i < trips; i++) {
            long n = s.nextLong(); // the number of sticks to buy
            long k = s.nextLong(); // the number of boxes for sale
            int b = s.nextInt(); // the number of boxes to buy

            String solution = solveBoxes(n, k, b);
            System.out.println(solution);
        }
    }

    // n - the number of sticks to buy
    // k - the number of boxes for sale
    // b - the number of boxes to buy
    public static String solveBoxes(long n, long k, int b) {
        StringBuilder solution = new StringBuilder();

        BigInteger maxDiff = new BigInteger(String.valueOf(k - b));
        BigInteger sticksLeft = new BigInteger(String.valueOf(n)).subtract(sumBetween(1, b));
        BigInteger maxValue = sumBetween(k-b+1, k);
        BigInteger stock = new BigInteger(String.valueOf(n));

        if (maxValue.compareTo(stock) < 0)
            return "-1";
        if (sumBetween(1, b).compareTo(stock) > 0)
            return "-1";


        for (long i = b; i > 0; i--) {
            if (sticksLeft.equals(BigInteger.ZERO))
                solution.append(i);
            else {
                if (sticksLeft.compareTo(maxDiff) >= 0) {
                    sticksLeft = sticksLeft.subtract(maxDiff);
                    solution.append(i + maxDiff.longValue());
                }else {
                    solution.append(i + sticksLeft.longValue());
                    sticksLeft = BigInteger.ZERO;
                }
            }

            if (i > 1)
                solution.append(" ");
        }

        return solution.toString();
    }

    public static BigInteger sumBetween(long beg, long end) {
        BigInteger b = new BigInteger(String.valueOf(beg));
        BigInteger e = new BigInteger(String.valueOf(end));
        BigInteger sum = b.add(e);
        BigInteger diff = e.subtract(b);
        sum = sum.multiply(diff.add(BigInteger.ONE));
        sum = sum.divide(new BigInteger("2"));
        return sum;
    }
}
