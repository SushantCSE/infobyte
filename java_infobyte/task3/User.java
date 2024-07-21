package task3;

import java.util.ArrayList;

public class User {
    private String userID;
    private String userPIN;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(String userID, String userPIN, double initialBalance) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePIN(String pin) {
        return this.userPIN.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getUserID() {
        return userID;
    }
}
