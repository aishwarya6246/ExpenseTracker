package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private List<Expense> expenses = new ArrayList<>();

    // Inner class representing an expense
    private class Expense {
        private String description;
        private double amount;

        public Expense(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Expense{" +
                    "description='" + description + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    // Add an expense to the list
    public void addExpense(String description, double amount) {
        expenses.add(new Expense(description, amount));
    }

    // Calculate the total amount of all expenses
    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    // Print all expenses
    public void printExpenses() {
        expenses.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();

        // Adding some expenses
        tracker.addExpense("Coffee", 3.5);
        tracker.addExpense("Lunch", 12.0);

        // Print all expenses
        System.out.println("Expenses:");
        tracker.printExpenses();

        // Print total expenses
        System.out.println("Total Expenses: " + tracker.getTotalExpenses());
    }
}
