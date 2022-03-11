package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class EPyramid {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Map<Integer, Integer> pyramid = new TreeMap<>();
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                int w = Integer.parseInt(line[0]);
                int h = Integer.parseInt(line[1]);

                if (pyramid.containsKey(w)) {
                    int hPyramid = pyramid.get(w);
                    if (hPyramid > h) h = hPyramid;
                }
                pyramid.put(w, h);
            }
            Collection<Integer> values = pyramid.values();
            long sum = 0;
            for (Integer el : values) {
                sum += el;
            }
            System.out.println(sum);
        } catch (IOException ignore) {

        }
    }
}
