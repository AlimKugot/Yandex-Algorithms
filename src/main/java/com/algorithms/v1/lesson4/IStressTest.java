package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class IStressTest {

    private static final String INPUT_PATH = "input.txt";

    public static void main(String[] args) {
        try {
            var tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(INPUT_PATH)));

            Map<String, List<Integer>> dictionary = new HashMap<>();

            tokenizer.nextToken();
            int dictionarySize = (int) tokenizer.nval;
            for (int i = 0; i < dictionarySize; i++) {
                tokenizer.nextToken();
                String word = tokenizer.sval;
                String key = tokenizer.sval.toLowerCase(Locale.ROOT);
                List<Integer> stressIndexes = upperCaseIndexes(word);

                if (dictionary.containsKey(key))
                    stressIndexes.addAll(dictionary.get(key));
                dictionary.put(key, stressIndexes);
            }

            int errorCount = 0;
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                String word = tokenizer.sval;
                String key = word.toLowerCase(Locale.ROOT);
                List<Integer> stressIndexes = upperCaseIndexes(word);

                if (stressIndexes.size() != 1) {
                    errorCount++;
                } else if (dictionary.containsKey(key)) {
                    List<Integer> dictList = dictionary.get(key);
                    if (!dictList.contains(stressIndexes.get(0))) errorCount++;
                }
            }
            System.out.println(errorCount);
        } catch (IOException ignore) {

        }
    }

    public static List<Integer> upperCaseIndexes(String word) {
        List<Integer> stressIndexes = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
                stressIndexes.add(i);
        }
        return stressIndexes;
    }
}


