package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class BSumOfCarNumbers {

    private static final String INPUT_PATH = "input.txt";

    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(INPUT_PATH)));

        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        tokenizer.nextToken();
        int k = (int) tokenizer.nval;

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            int number = (int) tokenizer.nval;
            arr.add(number);
        }

        System.out.println(findCountOfSumNumbersEqualsK(arr, n, k));
    }

    public static int findCountOfSumNumbersEqualsK(List<Integer> arr, int n, int k) {
        int count = 0;
        int sum = 0;
        for (int l = 0, r = 0; r < n || sum >= k; ) {
            if (sum < k) {
                sum += arr.get(r);
                r++;
            } else if (sum > k) {
                sum -= arr.get(l);
                l++;
            }

            if (sum == k) {
                count++;
                sum -= arr.get(l);
                l++;
            }
        }
        return count;
    }
}
