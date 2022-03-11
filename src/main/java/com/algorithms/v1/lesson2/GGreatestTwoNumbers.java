package com.algorithms.v1.lesson2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GGreatestTwoNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> res = maxMultiply(arr);
        System.out.println(res.get(0) + " " + res.get(1));
    }

    private static List<Integer> maxMultiply(List<Integer> arr) {
        Collections.sort(arr);
        final int N = arr.size();
        long first = (long) arr.get(0) * arr.get(1);
        long last = (long) arr.get(N - 1) * arr.get(N - 2);

        return (first > last) ? arr.subList(0, 2) : arr.subList(N - 2, N);
    }
}

