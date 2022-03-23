package com.algorithms.v1.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ECashier {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson7/E/input4.txt";
    private static final int START_TYPE = 1;
    private static final int END_TYPE = -1;

    private static int findSolution() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            int n = Integer.parseInt(reader.readLine());
            int j = 0;
            List<List<Integer>> schedule = new ArrayList<>(n * 4);

            for (int i = 0; i < n; i++, j++) {
                String[] inputLine = reader.readLine().split(" ");

                int startHour = Integer.parseInt(inputLine[0]);
                int startMinute = Integer.parseInt(inputLine[1]);
                int endHour = Integer.parseInt(inputLine[2]);
                int endMinute = Integer.parseInt(inputLine[3]);

                List<Integer> startList = fillList(startHour, startMinute, j, START_TYPE);
                schedule.add(startList);
                // if (start <= 00:00 && end >= 00:00) {}
                if (startHour >= 12 && (endHour >= 0 && endHour <= 12)) {
                    List<Integer> beforeNight = fillList(0, 0, j, END_TYPE);
                    List<Integer> afterNight = fillList(0, 0, ++j, START_TYPE);
                    schedule.add(beforeNight);
                    schedule.add(afterNight);
                }
                List<Integer> endList = fillList(endHour, endMinute, j, END_TYPE);
                schedule.add(endList);
//                if (startHour == endHour && startMinute == endMinute) {
//                    startHour -= 12;
//                    endHour += 12;
//                }
            }
            return findIntersection(schedule, j);
        }
    }

    private static List<Integer> fillList(int hour, int minute, int index, int type) {
        List<Integer> list = new ArrayList<>(3);
        list.add(hour);
        list.add(minute);
        list.add(index);
        list.add(type);
        return list;
    }

    private static int findIntersection(List<List<Integer>> arr, int cashCount) {
        arr.sort(Comparator.<List<Integer>>comparingInt(v -> v.get(0))
                .thenComparing(v -> v.get(1))
                .thenComparing(v -> v.get(2)));

        Set<Integer> openCashIndexes = new HashSet<>(cashCount);
        int res = 0;
        int count = 0;
        int allWorksStartHour = -1;
        int allWorksStartMinute = -1;
        for (List<Integer> row : arr) {
            int index = row.get(2);
            int type = row.get(3);

            if (type == START_TYPE) {
                openCashIndexes.add(index);
                count++;
                if (count == cashCount) {
                    allWorksStartHour = row.get(0);
                    allWorksStartMinute = row.get(1);
                }
            } else if (type == END_TYPE) {
                if (count == cashCount) {
                    int hours = (row.get(0) - allWorksStartHour) * 60;
                    int minutes = (row.get(1) - allWorksStartMinute);
                    res += hours + minutes;
                }
                openCashIndexes.remove(index);
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int res = findSolution();
        System.out.println(res);
    }
}
