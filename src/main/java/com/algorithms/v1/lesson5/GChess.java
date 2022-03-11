package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GChess {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson5/G/input4.txt";


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] splitLine = reader.readLine().split(" ");
            int n = Integer.parseInt(splitLine[0]);
            int k = Integer.parseInt(splitLine[1]);

            splitLine = reader.readLine().split(" ");


            Map<Long, Long> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long num = Long.parseLong(splitLine[i]);
                long count = 1;
                if (map.containsKey(num)) {
                    count = map.get(num) + 1;
                }
                map.put(num, count);
            }

            System.out.println(findCount(map, k));
        } catch (IOException ignored) {

        }
    }

    public static long findCount(Map<Long, Long> map, int k) {
        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        final int N = keys.size();

        long res = 0;
        int j = 0;

        long duplicates = 0;
        for (int i = 0; i < N; i++) {
            while (j < N && keys.get(i) * k >= keys.get(j)) {
                if (map.get(keys.get(j)) >= 2) {
                    duplicates++;
                }
                j++;
            }

            long countI = map.get(keys.get(i));
            long range = j - i;

            if (countI >= 2) {
                // 3 кол-во перестановок
                // range - 1 - любое число между l и r
                res += (range - 1) * 3;
                duplicates--;
            }
            if (countI >= 3) {
                res++;
            }
            // арифм прогрессия
            res += (range - 1) * (range - 2) * 3;
            res += duplicates * 3;
        }

        return res;
    }
}
