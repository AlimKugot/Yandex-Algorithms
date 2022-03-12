package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class FSails {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {

            Map<String, Map<String, Long>> mapMap = new TreeMap<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                String[] lineSplit = line.split(" ");

                String name = lineSplit[0];
                String product = lineSplit[1];
                long price = Long.parseLong(lineSplit[2]);

                Map<String, Long> productPriceMap;
                if (mapMap.containsKey(name)) {
                    productPriceMap = mapMap.get(name);
                    if (productPriceMap.containsKey(product)) {
                        long oldPrice = productPriceMap.get(product);
                        price += oldPrice;
                    }
                } else {
                    productPriceMap = new TreeMap<>();
                }
                productPriceMap.put(product, price);
                mapMap.put(name, productPriceMap);
            }

            for (Map.Entry<String, Map<String, Long>> mapEntry : mapMap.entrySet()) {
                // print name
                writer.println(mapEntry.getKey() + ":");
                // get product and price
                for (Map.Entry<String, Long> productPair : mapEntry.getValue().entrySet()) {
                    String res = productPair.getKey() + " " + productPair.getValue();
                    writer.println(res);
                }
            }
        } catch (IOException ignore) {

        }
    }
}

