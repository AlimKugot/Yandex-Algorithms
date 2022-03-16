package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HSubstring {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson5/H/input2.txt";


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {

            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            String s = reader.readLine();

            List<Integer> res = findSubstringWithLengthK(s, k);
            System.out.println(res.get(0) + " " + res.get(1));
        } catch (IOException ignored) {

        }
    }

    public static List<Integer> findSubstringWithLengthK(String s, int k) {
        final int N = s.length();


        int maxCount = 0;
        int maxIndex = 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i + k < N; i++) {
            String subI = s.substring(i, i + k);
            if (!set.contains(subI)) {
                int count = 1;
                for (int j = i + 2*k; j <= N; j += k) {
                    String subJ = s.substring(j - k, j);
                    if (subI.equals(subJ)) {
                        count++;
                    }
                }
                if (maxCount < count) {
                    maxCount = count*k;
                    maxIndex = i;
                }
                set.add(subI);
            }
        }
        List<Integer> result = new ArrayList<>(2);
        result.add(maxCount);
        result.add(maxIndex + 1);
        return result;
    }
}
