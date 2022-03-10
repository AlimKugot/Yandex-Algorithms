package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FAirConditioning {

    private static final String INPUT_PATH = "src/main/resources/cases/lesson5/F/input3.txt";

    public static void main(String[] args) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(INPUT_PATH)));

            List<Integer> schoolRooms = readList(tokenizer);
            Collections.sort(schoolRooms);
            Map<Integer, Integer> map = readMap(tokenizer);

            int i = 0;
            final int S_N = schoolRooms.size();
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int price = entry.getKey();
                int power = entry.getValue();
                while (i < S_N && power >= schoolRooms.get(i)) {
                    i++;
                    sum += price;
                }
                if (i >= S_N) break;
            }
            System.out.println(sum);
        } catch (IOException ignore) {

        }
    }

    private static Map<Integer, Integer> readMap(StreamTokenizer tokenizer) throws IOException {
        tokenizer.nextToken();
        int k = (int) tokenizer.nval;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            tokenizer.nextToken();
            int power = (int) tokenizer.nval;
            tokenizer.nextToken();
            int price = (int) tokenizer.nval;

//            if (map.containsValue(power) && price > map.get(power)) {
//                price = map.get(power);
//            }

            map.put(price, power);
        }
        return map;
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
}
