package com.algorithms.v1.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ISapper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        int x = in.nextInt();
        int mineCount = in.nextInt();

        List<List<Integer>> mine = new ArrayList<>(mineCount);
        for (int i = 0; i < mineCount; i++) {
            int mineX = in.nextInt();
            int mineY = in.nextInt();
            List<Integer> minePair = new ArrayList<>(2);
            minePair.add(mineY);
            minePair.add(mineX);

            mine.add(minePair);
        }

        char[][] res = sapper(x, y, mine);
        print(x, y, res);
    }

    private static char[][] sapper(int x, int y, List<List<Integer>> mine) {
        char[][] result = initGameField(x, y);
        for (List<Integer> arr : mine) {
            int mineX = arr.get(0) - 1;
            int mineY = arr.get(1) - 1;

            result[mineY][mineX] = '*';
            // up
            if (mineY - 1 >= 0) {
                // up-up
                if (result[mineY - 1][mineX] != '*') result[mineY - 1][mineX]++;
                // up-left
                if (mineX - 1 >= 0 && result[mineY - 1][mineX - 1] != '*') result[mineY - 1][mineX - 1]++;
                // up-right
                if (mineX + 1 < x && result[mineY - 1][mineX + 1] != '*') result[mineY - 1][mineX + 1]++;
            }
            // down
            if (mineY + 1 < y) {
                // down-down
                if (result[mineY + 1][mineX] != '*') result[mineY + 1][mineX]++;
                // down-left
                if (mineX - 1 >= 0 && result[mineY + 1][mineX - 1] != '*') result[mineY + 1][mineX - 1]++;
                // down-right
                if (mineX + 1 < x && result[mineY + 1][mineX + 1] != '*') result[mineY + 1][mineX + 1]++;
            }
            // left
            if (mineX >= 1 && result[mineY][mineX - 1] != '*') result[mineY][mineX - 1]++;
            // right
            if (mineX + 1 < x && result[mineY][mineX + 1] != '*') result[mineY][mineX + 1]++;
        }
        return result;
    }

    private static char[][] initGameField(int x, int y) {
        char[][] result = new char[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                result[i][j] = '0';
            }
        }
        return result;
    }

    private static void print(int x, int y, char[][] gameField) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
    }
}
