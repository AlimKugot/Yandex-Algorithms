package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GChess {

    private static final String INPUT_PATH = "src/main/resources/cases/lesson5/G/input2.txt";


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] splitLine = reader.readLine().split(" ");
            int n = Integer.parseInt(splitLine[0]);
            int k = Integer.parseInt(splitLine[1]);

            splitLine = reader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(splitLine[i]);
                arr.add(num);
            }

            System.out.println(solve(arr, n, k));
        } catch (IOException ignored) {

        }
    }

    public static int solve(List<Integer> arr, int n, int k) {
        Collections.sort(arr);
        int i = 0;
        int j = 2;

        //todo: первый случай отдельно обработать после while

        int count = 0;
        while (j < n) {
            int first = arr.get(i);
            int third = arr.get(j);

            if (third / first > k) {
                count += (j - 1 - i) * 3;
                i = j;
                j++;
            }
            j++;
        }
        return count;
    }
}
