package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DKeyboard {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = read(reader);
            int[] presses = read(reader);

            for (int press : presses) {
                arr[--press]--;
            }

            for (int press : arr) {
                String ans = (press >= 0) ? "NO" : "YES";
                System.out.println(ans);
            }
        } catch (IOException ignore) {

        }
    }

    private static int[] read(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int countPressing = Integer.parseInt(line[i]);
            arr[i] = countPressing;
        }
        return arr;
    }
}
