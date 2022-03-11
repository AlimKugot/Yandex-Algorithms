package com.algorithms.v1.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class CTelephoneCalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = changeNumber(in.nextLine().replaceAll("-", ""));

        for (int i = 0; i < 3; i++) {
            int[] numToCompare = changeNumber(in.nextLine().replaceAll("-", ""));
            String res = Arrays.equals(num, numToCompare) ? "YES" : "NO";
            System.out.println(res);
        }
    }

    private static int[] changeNumber(String number) {
        int[] result = new int[11];
        int i = 0;
        int ptr = 0;

        if (number.length() < 11) {
            result[i++] = 8;
            result[i++] = 4;
            result[i++] = 9;
            result[i++] = 5;
        } else if (number.charAt(ptr) == '+') {
            result[i++] = 8;
            ptr = ptr + 2;
        } else {
            result[i++] = number.charAt(ptr) - '0';
            ptr++;
        }

        while (ptr != number.length()) {
            if (Character.isDigit(number.charAt(ptr))) {
                result[i] = number.charAt(ptr) - '0';
                i++;
            }
            ptr++;
        }

        return result;
    }
}
