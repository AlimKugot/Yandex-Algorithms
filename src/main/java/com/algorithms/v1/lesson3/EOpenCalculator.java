package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class EOpenCalculator {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Character> keywords = new HashSet<>();
            String[] firstLine = reader.readLine().split(" ");
            char x = firstLine[0].charAt(0);
            char y = firstLine[1].charAt(0);
            char z = firstLine[2].charAt(0);
            keywords.add(x);
            keywords.add(y);
            keywords.add(z);

            char[] chars = reader.readLine().toCharArray();
            Set<Character> line = new HashSet<>();
            for (char aChar : chars) {
                line.add(aChar);
            }
            line.removeAll(keywords);
            System.out.println(line.size());
        } catch (IOException ignore) {

        }
    }
}
