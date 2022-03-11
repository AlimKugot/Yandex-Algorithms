package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class CCubes {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            String[] countString = reader.readLine().split(" ");
            int n = Integer.parseInt(countString[0]);
            int m = Integer.parseInt(countString[1]);

            Set<Integer> first = new TreeSet<>();
            Set<Integer> second = new TreeSet<>();
            Set<Integer> containsAll = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(reader.readLine());
                first.add(num);
            }
            for (int i = 0; i < m; i++) {
                Integer num = Integer.parseInt(reader.readLine());
                if (first.remove(num)) {
                    containsAll.add(num);
                } else {
                    second.add(num);
                }
            }
            print(writer, containsAll);
            print(writer, first);
            print(writer, second);
        } catch (IOException ignore) {

        }
    }

    static void print(PrintWriter writer, Set<Integer> set) {
        writer.println(set.size());
        set.forEach(el -> writer.print(el + " "));
        writer.println();
    }
}

