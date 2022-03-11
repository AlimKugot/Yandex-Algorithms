package com.algorithms.v1.lesson1;

import java.util.Scanner;

import static java.lang.Math.max;

public class FLaptops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        // left up
        int a = max(a2, b1);
        int b = a1 + b2;

        // left down
        if (max(a2, b2)*(a1+b1) <= a*b) {
            a = max(a2, b2);
            b = a1 + b1;
        }
        // right up
        if (max(a1, b2)*(a2+b1) <= a*b) {
            a = max(a1, b2);
            b = a2 + b1;
        }
        // right down
        if (max(a1, b1)*(a2+b2) <= a*b) {
            a = max(a1, b1);
            b = a2 + b2;
        }

        System.out.println(a + " " + b);
    }
}
