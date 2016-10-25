/*
We define a modified Fibonacci sequence using the following definition:

ti+2 = t1 + (t1+1)^2

Given three integers, t1, t2, and n, compute and print term tn of a
modified Fibonacci sequence.

Note: The value of tn may far exceed the range of a -bit integer. Many
submission languages have libraries that can handle such large results
but, for those that don't (e.g., C++), you will need to be more creative
in your solution to compensate for the limitations of your chosen
submission language.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t1 = input.nextInt(),
            t2 = input.nextInt(),
            n  = input.nextInt();

        System.out.println(fib(t1, t2, n).toString());
    }

    public static BigInteger fib(int t1, int t2, int n) {

        Map<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();
        BigInteger f = BigInteger.ONE;
        if (map.containsKey(n))     f = map.get(n);
        else if (n == 1)            f = new BigInteger(Integer.toString(t1));
        else if (n == 2)            f = new BigInteger(Integer.toString(t2));
        else {
            f = fib(t1, t2, n-1).pow(2).add(fib(t1, t2, n-2));
            map.put(n, f);
        }
        return f;
    }
}
