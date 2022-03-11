package com.algorithms.v1.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BKindOfSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        for (String line = in.nextLine(); !line.isEmpty() && !line.equals("-2000000000"); line = in.nextLine()) {
            Integer num = Integer.parseInt(line);
            arr.add(num);
        }

        String ans = kindOfSequence(arr);
        System.out.println(ans);
    }

    private static String kindOfSequence(List<Integer> arr) {
        final int N = arr.size();

        boolean isIncrease = false;
        boolean isDecrease = false;
        boolean isContainsEqualNumber = false;

        int a1 = arr.get(0);
        int a2 = arr.get(1);

        if (a2 > a1) {
            isIncrease = true;
        } else if (a2 < a1) {
            isDecrease = true;
        } else {
            isContainsEqualNumber = true;
        }

        for (int i = 2; i < N; i++) {
            a1 = arr.get(i - 1);
            a2 = arr.get(i);

            if (a2 > a1) {
                isIncrease = true;
                if (isDecrease) {
                    return "RANDOM";
                }
            } else if (a2 < a1) {
                isDecrease = true;
                if (isIncrease) {
                    return "RANDOM";
                }
            } else {
                isContainsEqualNumber = true;
            }
        }

        if (isIncrease) {
            if (isContainsEqualNumber) {
                return "WEAKLY ASCENDING";
            } else {
                return "ASCENDING";
            }
        } else if (isDecrease) {
            if (isContainsEqualNumber) {
                return "WEAKLY DESCENDING";
            } else {
                return "DESCENDING";
            }
        } else {
            return "CONSTANT";
        }
    }
}
