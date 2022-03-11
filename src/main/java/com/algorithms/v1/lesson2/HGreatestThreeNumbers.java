package com.algorithms.v1.lesson2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class HGreatestThreeNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> arr = Arrays.stream(in.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        List<Long> res = maxMultiply(arr);
        System.out.println(res.get(0) + " " + res.get(1) + " " + res.get(2));
    }

    private static List<Long> maxMultiply(List<Long> arr) {
        arr.sort(Collections.reverseOrder());
        final int N = arr.size();
        long a1 = arr.get(0);
        long a2 = arr.get(1);
        long a3 = arr.get(2);
        long l1 = arr.get(N - 1);
        long l2 = arr.get(N - 2);
        long l3 = arr.get(N - 3);

        long first = a1 * a2 * a3;
        long last = l1 * l2 * l3;
        long third = l1 * l2 * a1;

        if (first > last && first > third) {
            return arr.subList(0, 3);
        } else if (last > first && last > third) {
            return arr.subList(N - 3, N);
        } else {
            return List.of(l2, l1, a1);
        }
    }
}

