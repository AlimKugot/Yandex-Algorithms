package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABinSearch {

    private static String isContains(long[] arr, long target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]) {
                r = mid;
            } else {
                return "YES";
            }
        }
        return "NO";
    }


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            long[] arr = new long[n];
            line = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }

            line = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(line[i]);
                System.out.println(isContains(arr, num));
            }
        } catch (IOException ignored) {

        }
    }
}
