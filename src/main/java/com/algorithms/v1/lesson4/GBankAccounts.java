package com.algorithms.v1.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GBankAccounts {

    private static final Map<String, Integer> accounts = new HashMap<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                String[] lineSplit = line.split(" ");

                String command = lineSplit[0];
                switch (command) {
                    case "DEPOSIT" -> deposit(lineSplit);
                    case "WITHDRAW" -> withdraw(lineSplit);
                    case "BALANCE" -> balance(lineSplit);
                    case "TRANSFER" -> transfer(lineSplit);
                    case "INCOME" -> income(lineSplit);
                }
            }
        } catch (IOException ignore) {

        }
    }


    private static void income(String[] args) {
        int p = Integer.parseInt(args[1]);

        for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
            int account = entry.getValue();
            if (account > 0) {
                String name = entry.getKey();
                int percent = (int) Math.floor(account * (p * 1.0 / 100));
                account += percent;
                accounts.put(name, account);
            }
        }
    }

    private static void transfer(String[] args) {
        String name1 = args[1];
        String name2 = args[2];
        int sum = Integer.parseInt(args[3]);

        withdraw(name1, sum);
        deposit(name2, sum);
    }

    private static void balance(String[] args) {
        String name = args[1];
        Integer sum = accounts.get(name);

        if (sum == null) {
            System.out.println("ERROR");
        } else {
            System.out.println(sum);
        }
    }

    private static void deposit(String[] args) {
        String name = args[1];
        int sum = Integer.parseInt(args[2]);
        deposit(name, sum);
    }

    private static void withdraw(String[] args) {
        String name = args[1];
        int sum = Integer.parseInt(args[2]);
        withdraw(name, sum);
    }

    private static void deposit(String name, int sum) {
        if (accounts.containsKey(name)) {
            sum += accounts.get(name);
        }
        accounts.put(name, sum);
    }

    private static void withdraw(String name, int sum) {
        int account = -sum;
        if (accounts.containsKey(name)) {
            account = accounts.get(name) - sum;
        }
        accounts.put(name, account);
    }
}
