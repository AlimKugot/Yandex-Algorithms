package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class AStyle {

    private static final String INPUT_PATH = "input.txt";

    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(INPUT_PATH)));

        List<Integer> arr1 = readList(tokenizer);
        List<Integer> arr2 = readList(tokenizer);

        int[] res = findPairWithMinDiff(arr1, arr2);
        System.out.println(res[0] + " " + res[1]);
    }

    private static List<Integer> readList(StreamTokenizer tokenizer) throws IOException {
        tokenizer.nextToken();
        final int N = (int) tokenizer.nval;
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            tokenizer.nextToken();
            int number = (int) tokenizer.nval;
            list.add(number);
        }
        return list;
    }

    private static int[] findPairWithMinDiff(List<Integer> arr1, List<Integer> arr2) {
        final int SIZE1 = arr1.size();
        final int SIZE2 = arr2.size();

        int l = 0, r = 0;
        int[] pair = new int[2];

        int diff = Integer.MAX_VALUE;
        while (l < SIZE1 && r < SIZE2) {
            int num1 = arr1.get(l);
            int num2 = arr2.get(r);

            int currentDiff = Math.abs(num1 - num2);
            if (currentDiff == 0) {
                pair[0] = num1;
                pair[1] = num2;
                return pair;
            } else if (diff > currentDiff) {
                diff = currentDiff;
                pair[0] = num1;
                pair[1] = num2;
            }

            if (num1 > num2) {
                r++;
            } else {
                l++;
            }
        }
        return pair;
    }
}
