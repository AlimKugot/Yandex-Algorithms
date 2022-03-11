package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class ADictionary {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());

            Map<String, String> keyValue = new TreeMap<>();
            Map<String, String> valueKey = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                String key = line[0];
                String value = line[1];
                keyValue.put(key, value);
                valueKey.put(value, key);
            }
            String pair = reader.readLine();

            String res = keyValue.get(pair);
            if (res == null) res = valueKey.get(pair);
            System.out.println(res);
        } catch (IOException ignore) {

        }
    }
}
