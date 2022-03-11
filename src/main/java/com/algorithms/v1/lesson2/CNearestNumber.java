package com.algorithms.v1.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CNearestNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            arr.add(num);
        }
        int x = in.nextInt();

        int ans = minDifference(arr, x);
        System.out.println(ans);
    }

    private static int minDifference(List<Integer> arr, int x) {
        int num = arr.get(0);
        int minDiff = Math.abs(num - x);

        final int N = arr.size();
        for (int i = 1; i < N; i++) {
            int diff = Math.abs(arr.get(i) - x);
            if (minDiff > diff) {
                minDiff = diff;
                num = arr.get(i);
            }
        }
        return num;
    }
}
