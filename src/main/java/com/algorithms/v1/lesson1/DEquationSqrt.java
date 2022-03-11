package com.algorithms.v1.lesson1;

import java.util.Scanner;

public class DEquationSqrt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ans = "NO SOLUTION";

        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        int c = Integer.parseInt(in.nextLine());

        if (c >= 0) {
            if (a == 0 && c*c == b) {
                ans = "MANY SOLUTIONS";
            } else {
                double x = (c*c - b)*1.0/a;
                if (x % 1 == 0) {
                    ans = ((int) x) + "";
                }
            }
        }
        System.out.println(ans);
    }
}
