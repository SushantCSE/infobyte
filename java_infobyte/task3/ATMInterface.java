package task3;
import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayLogin() {
        System.out.println("Welcome to the ATM!");
    }

    public static void displayMenu() {
        System.out.println("\n1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void showTransactionHistory(User user) {
        System.out.println("Transaction History:");
        for (String transaction : user.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    public static void promptWithdraw(User user) {
        double amount = Double.parseDouble(getUserInput("Enter amount to withdraw: "));
        Transaction.withdraw(user, amount);
    }

    public static void promptDeposit(User user) {
        double amount = Double.parseDouble(getUserInput("Enter amount to deposit: "));
        Transaction.deposit(user, amount);
    }

    public static void promptTransfer(User user, Bank bank) {
        String toUserID = getUserInput("Enter the recipient user ID: ");
        User toUser = bank.getUser(toUserID);
        if (toUser != null) {
            double amount = Double.parseDouble(getUserInput("Enter amount to transfer: "));
            Transaction.transfer(user, toUser, amount);
        } else {
            System.out.println("Recipient user not found!");
        }
    }
}
