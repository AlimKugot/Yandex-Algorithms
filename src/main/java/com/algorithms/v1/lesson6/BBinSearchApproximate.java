package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BBinSearchApproximate {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson6/B/input3.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] inputSplit = reader.readLine().split(" ");
            int n = Integer.parseInt(inputSplit[0]);
            int m = Integer.parseInt(inputSplit[1]);

            inputSplit = reader.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputSplit[i]);
            }

            inputSplit = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(inputSplit[i]);
                System.out.println(binSearchApproximate(arr, num));
            }
        } catch (IOException ignored) {

        }
    }

    private static int binSearchApproximate(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (r - l > 1) {
            int mid = (l + r + 1) / 2;
            if (target > arr[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int leftDiff = target - arr[l];
        int rightDiff = arr[r] - target;
        return (leftDiff <= rightDiff) ? arr[l] : arr[r];
    }
}