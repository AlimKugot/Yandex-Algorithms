package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FPrinters {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson6/F/input5.txt";

    // подвох для самого первого случая:
    // мы имеем только 1 лист (оригинал), нужно распечатать на самом быстром
    // далее мы можем пользоваться любым принтером (тк листов уже >= 2)
    public static long findMinimalTime(long n, long x, long y) {
        long l = 0;
        long r = n * Math.min(x, y);
        while (l < r) {
            long mid = (l + r) / 2;
            if ((mid / x) + (mid / y) < n - 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l + Math.min(x, y);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] line = reader.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            long x = Long.parseLong(line[1]);
            long y = Long.parseLong(line[2]);

            System.out.println(findMinimalTime(n, x, y));
        } catch (IOException ignored) {

        }
    }
}
