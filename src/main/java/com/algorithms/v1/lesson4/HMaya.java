package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HMaya {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = reader.readLine().split(" ");
            int wLength = Integer.parseInt(input[0]);
            int sLength = Integer.parseInt(input[1]);

            int matchCount = 0;
            char[] w = new char[wLength];
            char[] s = new char[sLength];
            reader.read(w);
            // newLine
            reader.read();
            reader.read(s);

            // last letter for unknown symbols
            int[] lettersW = new int[57];
            int[] lettersS = new int[57];

            int sumLettersOfW = fillArray(w, lettersW, 0, w.length);
            int sumLettersOfS = fillArray(s, lettersS, 0, w.length);

            if (sumLettersOfS == sumLettersOfW && Arrays.equals(lettersW, lettersS)) {
                matchCount++;
            }
            sumLettersOfS -= s[0];
            lettersS[convert(s[0])]--;

            // check S
            for (int i = w.length; i < s.length; i++) {
                char c = s[i];
                int index = convert(c);

                lettersS[index]++;
                sumLettersOfS += c;
                if (sumLettersOfS == sumLettersOfW && Arrays.equals(lettersW, lettersS)) {
                    matchCount++;
                }
                int firstI = i - wLength + 1;
                char firstC = s[firstI];
                int firstIndex = convert(firstC);
                lettersS[firstIndex]--;
                sumLettersOfS -= firstC;
            }
            System.out.println(matchCount);
        } catch (IOException ignore) {

        }
    }

    private static int fillArray(char[] source, int[] letters, int from, int to) {
        int sumOfLetters = 0;
        for (int i = from; i < to; i++) {
            char c = source[i];
            sumOfLetters += c;
            int index = convert(c);
            letters[index]++;
        }
        return sumOfLetters;
    }

    private static int convert(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        } else if (Character.isLowerCase(c)) {
            return 27 + c - 'a';
        } else {
            return 57;
        }
    }

}
