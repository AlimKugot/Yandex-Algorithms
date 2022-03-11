package com.algorithms.v1.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DGreaterNeighbours {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int ans = countNeighborhood(arr);
        System.out.println(ans);
    }

    private static int countNeighborhood(List<Integer> arr) {
        int res = 0;
        final int N = arr.size();
        if (N < 1) return res;

        for (int i = 2; i < N; i++) {
            int first = arr.get(i - 2);
            int mid = arr.get(i - 1);
            int last = arr.get(i);

            if (mid > first && mid > last) res++;
        }

        return res;
    }
}

