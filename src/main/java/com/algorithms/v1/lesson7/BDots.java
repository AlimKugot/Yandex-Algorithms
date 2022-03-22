package com.algorithms.v1.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BDots {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson7/B/input6.txt";


    public static int[] countInclusions(int n, int m, List<Integer> start, List<Integer> end, List<Integer> dots) {
        final int START = -1;
        final int POINT = 0;
        final int END = 1;
        List<List<Integer>> arr = new ArrayList<>(n * 2 + m);

        for (int i = 0; i < n; i++) {
            List<Integer> first = new ArrayList<>(3);
            List<Integer> second = new ArrayList<>(3);

            int min = Math.min(start.get(i), end.get(i));
            int max = Math.max(start.get(i), end.get(i));
            int index = -1;

            first.add(min);
            first.add(START);
            first.add(index);

            second.add(max);
            second.add(END);
            second.add(index);

            arr.add(first);
            arr.add(second);
        }
        for (int i = 0; i < m; i++) {
            List<Integer> points = new ArrayList<>(2);
            points.add(dots.get(i));
            points.add(POINT);
            points.add(i);
            arr.add(points);
        }
        arr.sort(Comparator.<List<Integer>>comparingInt(v -> v.get(0))
                .thenComparing(v -> v.get(1))
                .thenComparing(v -> v.get(2)));

        int current = 0;
        int[] res = new int[m];
        for (List<Integer> pair : arr) {
            if (pair.get(1) == START) {
                ++current;
            } else if (pair.get(1) == END) {
                --current;
            } else if (pair.get(1) == POINT) {
                int index = pair.get(2);
                res[index] = current;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {

            String[] inputSplit = reader.readLine().split(" ");
            int n = Integer.parseInt(inputSplit[0]);
            int m = Integer.parseInt(inputSplit[1]);

            List<Integer> start = new ArrayList<>(n);
            List<Integer> end = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                inputSplit = reader.readLine().split(" ");
                int from = Integer.parseInt(inputSplit[0]);
                int to = Integer.parseInt(inputSplit[1]);
                start.add(from);
                end.add(to);
            }

            List<Integer> dots = new ArrayList<>(m);
            inputSplit = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(inputSplit[i]);
                dots.add(num);
            }

            int[] res = countInclusions(n, m, start, end, dots);
            for (Integer el : res) {
                System.out.print(el + " ");
            }
        } catch (IOException ignored) {

        }
    }
}
