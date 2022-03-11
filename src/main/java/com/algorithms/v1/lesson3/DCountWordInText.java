package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DCountWordInText {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<String> set = new HashSet<>();
            while (true){
                String line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                String[] word = line.split("\s");
                set.addAll(Arrays.asList(word));
            }
            System.out.println(set.size());
        } catch (IOException ignore) {

        }
    }
}
