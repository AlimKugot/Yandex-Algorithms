package com.algorithms.v1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IPolyglots {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countSchool = Integer.parseInt(reader.readLine());
            List<Set<String>> sets = new ArrayList<>(countSchool);
            Set<String> local = new TreeSet<>(Collections.reverseOrder());

            for (int i = 0; i < countSchool; i++) {
                int countStudent = Integer.parseInt(reader.readLine());
                Set<String> languages = new HashSet<>(countStudent);
                for (int j = 0; j < countStudent; j++) {
                    String lang = reader.readLine();
                    languages.add(lang);
                    local.add(lang);
                }
                sets.add(languages);
            }
            Set<String> allKnows = new HashSet<>(sets.get(0));
            for (int i = 1; i < sets.size(); i++) {
                allKnows.retainAll(sets.get(i));
            }

            print(allKnows);
            print(local);
        } catch (IOException ignore) {

        }
    }

    private static void print(Set<String> set) {
        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}

