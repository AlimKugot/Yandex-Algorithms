package com.algorithms.v1.lesson3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ACountOfDifferentNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(set.size());
    }
}
