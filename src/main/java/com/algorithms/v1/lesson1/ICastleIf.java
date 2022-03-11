package com.algorithms.v1.lesson1;

import java.util.Scanner;

public class ICastleIf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int A = in.nextInt();
        final int B = in.nextInt();
        final int C = in.nextInt();
        final int D = in.nextInt();
        final int E = in.nextInt();

        if ((A <= D && B <= E) || (A <= E && B <= D)
                || (A <= D && C <= E) || (A <= E && C <= D)
                || (B <= D && C <= E) || (B <= E && C <= D)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
