package com.algorithms.v1.lesson1;

import java.util.Scanner;


public class AConditioner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tRoom = in.nextInt();
        int tCond = in.nextInt();
        String mode = in.next();

        if (tRoom < tCond) {
            if (mode.equals("auto") || mode.equals("heat")) {
                // heat
                System.out.println(tCond);
            } else {
                // nothing
                System.out.println(tRoom);
            }
        } else if (tRoom > tCond) {
            if (mode.equals("auto") || mode.equals("freeze")) {
                // freeze
                System.out.println(tCond);
            } else {
                // nothing
                System.out.println(tRoom);
            }
        } else {
            System.out.println(tRoom);
        }
    }

}

