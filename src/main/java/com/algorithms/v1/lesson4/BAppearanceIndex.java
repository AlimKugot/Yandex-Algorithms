package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BAppearanceIndex {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Map<String, Integer> map = new TreeMap<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                String[] words = line.split(" ");

                for (String word : words) {
                    String res = "0 ";
                    if (map.containsKey(word)) {
                        int count = map.get(word) + 1;
                        res = count + " ";
                        map.put(word, count);
                    } else {
                        map.put(word, 0);
                    }
                    System.out.print(res);
                }
            }
        } catch (IOException ignore) {

        }
    }
}
