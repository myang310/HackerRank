/*
Sami's spaceship crashed on Mars! She sends n sequential
SOS messages to Earth for help.

Letters in some of the SOS messages are altered by cosmic
radiation during transmission. Given the signal received
by Earth as a string, S, determine how many letters of
Sami's SOS have been changed by radiation.

Link: https://www.hackerrank.com/challenges/mars-exploration
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int charsChanged = radiationEffect(S);
        System.out.println(charsChanged);
    }

    public static int radiationEffect(String str) {
        int count = 0;
        char[] sos = {'S', 'O', 'S'};
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != sos[i % 3])
                count++;
        }
        return count;
    }
}
