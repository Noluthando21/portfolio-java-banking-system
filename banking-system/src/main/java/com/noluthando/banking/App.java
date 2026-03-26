package com.noluthando.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. List Accounts");
            System.out.println("3. Transfer Money");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Owner name: ");
                String owner = scanner.nextLine();

                System.out.print("Starting balance: ");
                double balance = Double.parseDouble(scanner.nextLine());

                accounts.add(new Account(owner, balance));
                System.out.println("Account created.");

            } else if (choice.equals("2")) {
                if (accounts.isEmpty()) {
                    System.out.println("No accounts found.");
                } else {
                    for (int i = 0; i < accounts.size(); i++) {
                        Account acc = accounts.get(i);
                        System.out.println(i + ": " + acc.getOwner() + " | Balance: " + acc.getBalance());
                    }
                }

            } else if (choice.equals("3")) {
                if (accounts.size() < 2) {
                    System.out.println("You need at least 2 accounts to transfer.");
                    continue;
                }

                try {
                    System.out.print("From account index: ");
                    int fromIndex = Integer.parseInt(scanner.nextLine());

                    System.out.print("To account index: ");
                    int toIndex = Integer.parseInt(scanner.nextLine());

                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    Account from = accounts.get(fromIndex);
                    Account to = accounts.get(toIndex);

                    from.transfer(to, amount);

                    System.out.println("Transfer successful.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice.equals("4")) {
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}