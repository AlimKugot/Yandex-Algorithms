package com.algorithms.v1.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GArea {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson6/G/input2.txt";

    private static boolean check(long t, long n, long m, long mid) {
        long vertical = 2 * mid * n;
        long horizontal = 2 * mid * m;
        long edges = mid * mid * 4;

        long tileCount = vertical + horizontal - edges;

        return tileCount <= n * m && tileCount <= t;
    }

    private static long findTileSize(long t, long n, long m) {
        long l = 0;
        long r = n / 2;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (check(t, n, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            long n = Long.parseLong(reader.readLine());
            long m = Long.parseLong(reader.readLine());
            long t = Long.parseLong(reader.readLine());

            System.out.println(findTileSize(t, n, m));
        } catch (IOException ignored) {

        }
    }
}
