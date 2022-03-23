package com.algorithms.v1.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSeatPlaces {

    private static final int START = 1;
    private static final int END = -1;

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson7/C/input4.txt";

    public static void findOptimalDistribution(int n, int d, List<List<Integer>> arr) {
        arr.sort(Comparator.<List<Integer>>comparingInt(v -> v.get(0))
                .thenComparing(v -> v.get(1)));

        int current = 0;
        int max = 1;
        for (List<Integer> pair : arr) {
            if (pair.get(1) == START) {
                current++;
                max = Math.max(max, current);
                pair.add(current);
            } else if (pair.get(1) == END) {
                --current;
            }
        }
        arr = arr.stream()
                .filter(v -> v.get(1) == START)
                .sorted(Comparator.comparingInt(v -> v.get(2)))
                .collect(Collectors.toList());

        System.out.println(max);
        arr.stream()
                .filter(v -> v.get(1) == START)
                .sorted(Comparator.comparingInt(v -> v.get(2)))
                .forEach(v -> System.out.print(v.get(3) + " "));
    }


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {

            String[] inputSplit = reader.readLine().split(" ");
            int n = Integer.parseInt(inputSplit[0]);
            int d = Integer.parseInt(inputSplit[1]);

            List<List<Integer>> studentList = new ArrayList<>(n * 2);
            inputSplit = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                List<Integer> start = new ArrayList<>(4);
                List<Integer> end = new ArrayList<>(4);
                int xi = Integer.parseInt(inputSplit[i]);

                start.add(xi);
                start.add(START);
                start.add(i);

                end.add(xi + d);
                end.add(END);
                end.add(i);

                studentList.add(start);
                studentList.add(end);
            }

            findOptimalDistribution(n, d, studentList);
        } catch (IOException ignored) {

        }
    }
}
