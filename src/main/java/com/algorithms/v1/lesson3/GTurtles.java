package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GTurtles {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Set<Integer> trueSet = new HashSet<>(n);
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                int after = Integer.parseInt(line[0]);
                int before = Integer.parseInt(line[1]);

                if (before >= 0 && after >= 0 && before + after == n - 1) {
                    trueSet.add(before);
                }
            }
            System.out.println(trueSet.size());
        } catch (IOException ignore) {

        }
    }
}
