package com.algorithms.v1.lesson1;

import java.util.Scanner;

public class BTriangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        String ans = (a + b > c && a + c > b && b + c > a) ? "Yes" : "No";
        System.out.println(ans);
    }
}
