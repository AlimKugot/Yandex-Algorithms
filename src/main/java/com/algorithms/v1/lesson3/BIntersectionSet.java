package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BIntersectionSet {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            Set<Integer> set1 = readSet(reader);
            Set<Integer> set2 = readSet(reader);

            set1.retainAll(set2);
            set1.forEach(el -> writer.print(el + " "));
        } catch (IOException ignore) {

        }
    }

    private static Set<Integer> readSet(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        return Arrays.stream(line)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
