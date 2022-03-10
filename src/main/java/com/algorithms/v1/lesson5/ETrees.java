package com.algorithms.v1.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ETrees {
    private static final String INPUT_PATH = "src/main/resources/cases/lesson5/D/input3.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            line = reader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>(n);
            for (String strNum : line) {
                arr.add(Integer.parseInt(strNum));
            }


        } catch (IOException ignore){

        }
    }

    public static List<Integer> findSavingTrees(List<Integer> a) {
        return null;
    }

}
