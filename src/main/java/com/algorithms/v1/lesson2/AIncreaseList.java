package com.algorithms.v1.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AIncreaseList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] line = in.nextLine().split(" ");
        List<Integer> arr = Arrays.stream(line)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String ans = isIncrease(arr) ? "YES" : "NO";
        System.out.println(ans);
    }

    private static boolean isIncrease(List<Integer> arr) {
        final int N = arr.size();
        for (int i = 1; i < N; i++) {
            int a1 = arr.get(i - 1);
            int a2 = arr.get(i);

            if (a2 <= a1) {
                return false;
            }
        }
        return true;
    }
}

