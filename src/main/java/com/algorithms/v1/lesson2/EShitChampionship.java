package com.algorithms.v1.lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class EShitChampionship {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

        int ans = vasilyPosition(arr);
        System.out.println(ans);
    }

    private static int vasilyPosition(List<Integer> arr) {
        int vasilyPoints = -1;
        final int N = arr.size();
        List<Integer> positions = new ArrayList<>(arr).stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        int max = positions.get(0);
        boolean wasChamp = false;

        for (int i = 2; i < N; i++) {
            int first = arr.get(i - 2);
            int mid = arr.get(i - 1);
            int last = arr.get(i);

            if (first == max) wasChamp = true;
            if (wasChamp && mid % 10 == 5 && mid > last && mid > vasilyPoints) {
                vasilyPoints = mid;
            }
        }

        return positions.indexOf(vasilyPoints) + 1;
    }
}

