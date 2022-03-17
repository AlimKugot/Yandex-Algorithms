package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DCosmoHostel {


    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson6/D/input4.txt";

    private static long binSearch(long n, long a, long b, long w, long h) {
        long l = 0;
        long r = w;
        while (l < r) {
            long mid = (l + r) / 2;
            long valueW = a + 2 * mid;
            long valueH = b + 2 * mid;

            if (((w / valueW) * (h / valueH) >= n) || ((w / valueH) * (h / valueW)  >= n)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] inputSplit = reader.readLine().split(" ");
            long n = Long.parseLong(inputSplit[0]);
            long a = Long.parseLong(inputSplit[1]);
            long b = Long.parseLong(inputSplit[2]);
            long w = Long.parseLong(inputSplit[3]);
            long h = Long.parseLong(inputSplit[4]);


            System.out.println(binSearch(n, a, b, w, h));
        } catch (IOException ignored) {

        }
    }
}
