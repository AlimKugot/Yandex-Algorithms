package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DDate {

    private static final String INPUT_PATH = "src/main/resources/cases/lesson5/D/input3.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);

            line = reader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>(n);
            for (String strNum : line) {
                arr.add(Integer.parseInt(strNum));
            }

            System.out.println(countPossibleDatePlaces(arr, r));
        } catch (IOException ignore){

        }
    }

    public static long countPossibleDatePlaces(List<Integer> arr, int r) {
        int i = 0;
        int j = 1;
        long count = 0;
        final int N = arr.size();

        while (j < N) {
            if (arr.get(j) - arr.get(i) <= r) {
                j++;
            } else {
                count += N - j;
                i++;
            }
        }
        return count;
    }
}
