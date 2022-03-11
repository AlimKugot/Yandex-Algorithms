package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class COftenWord {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {


            int maxCount = 0;
            Map<String, Integer> map = new TreeMap<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                String[] words = line.split(" ");


                for (String word : words) {
                    if (map.containsKey(word)) {
                        int count = map.get(word) + 1;
                        if (count > maxCount) maxCount = count;
                        map.put(word, count);
                    } else {
                        map.put(word, 0);
                    }
                }

            }
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (pair.getValue() == maxCount) {
                    System.out.println(pair.getKey());
                    break;
                }
            }
        } catch (IOException ignore) {

        }
    }
}
