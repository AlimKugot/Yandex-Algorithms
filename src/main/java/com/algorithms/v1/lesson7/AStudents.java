package com.algorithms.v1.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AStudents {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson7/A/input1.txt";


    public static int findCountOfBadStudents(int n, int m, List<Integer> start, List<Integer> end) {
        final int START = -1;
        final int END = 1;
        List<List<Integer>> arr = new ArrayList<>(m * 2);

//        int[][] res = new int[m * 2][2];
        for (int i = 0, j = 0; i < m; i++, j += 2) {
            List<Integer> first = new ArrayList<>(2);
            List<Integer> second = new ArrayList<>(2);

            first.add(start.get(i));
            first.add(START);
            second.add(end.get(i));
            second.add(END);

            arr.add(first);
            arr.add(second);
        }

        Comparator<List<Integer>> comparator = (o1, o2) -> {
            int first = o1.get(0);
            int second = o2.get(0);
            if (first == second) {
                return Integer.compare(o1.get(1), o2.get(1));
            } else {
                return Integer.compare(first, second);
            }
        };
        arr.sort(comparator);


        int current = 0;
        int res = arr.get(0).get(0) - 1;
        int lastOut = n + 1;
        int firstIn = n + 1;
        for (List<Integer> pair : arr) {
            if (pair.get(1) == START) {
                if (current == 0) {
                    firstIn = pair.get(0);
                    if (firstIn > lastOut) {
                        res += firstIn - lastOut - 1;
                    }
                }
                ++current;
            } else if (pair.get(1) == END) {
                --current;
                if (current == 0) {
                    lastOut = pair.get(0);
                }
            }
        }
        res += n - lastOut;
        return res;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {

            String[] inputSplit = reader.readLine().split(" ");
            int n = Integer.parseInt(inputSplit[0]);
            int m = Integer.parseInt(inputSplit[1]);

            List<Integer> start = new ArrayList<>(m);
            List<Integer> end = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                inputSplit = reader.readLine().split(" ");
                int from = Integer.parseInt(inputSplit[0]);
                int to = Integer.parseInt(inputSplit[1]);
                start.add(from);
                end.add(to);
            }

            int res = findCountOfBadStudents(n, m, start, end);
            System.out.println(res);
        } catch (IOException ignored) {

        }
    }
}
