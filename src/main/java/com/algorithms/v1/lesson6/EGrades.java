package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EGrades {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson6/E/input2.txt";

    private static boolean check(long a, long b, long c, long mid) {
        long sum = (2 * a) + (3 * b) + (4 * c) + (5 * mid);
        long count = a + b + c + mid;
        return sum * 2 >= count * 7;
    }

    private static long binSearchGradeCount(long a, long b, long c) {
        long l = 0;
        long r = 100_000_000_000_000_000L;

        while (l < r) {
            long mid = (l + r) / 2;

            if (check(a, b, c, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            long a = Long.parseLong(reader.readLine());
            long b = Long.parseLong(reader.readLine());
            long c = Long.parseLong(reader.readLine());

            System.out.println(binSearchGradeCount(a, b, c));
        } catch (IOException ignored) {

        }
    }
}
