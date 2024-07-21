package task3;
public class Transaction {
    public static void withdraw(User user, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            user.updateBalance(-amount);
            recordTransaction(user, "Withdrawn: " + amount);
            System.out.println("Withdrawal successful!");
        }
    }

    public static void deposit(User user, double amount) {
        user.updateBalance(amount);
        recordTransaction(user, "Deposited: " + amount);
        System.out.println("Deposit successful!");
    }

    public static void transfer(User fromUser, User toUser, double amount) {
        if (amount > fromUser.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            fromUser.updateBalance(-amount);
            toUser.updateBalance(amount);
            recordTransaction(fromUser, "Transferred: " + amount + " to " + toUser.getUserID());
            recordTransaction(toUser, "Received: " + amount + " from " + fromUser.getUserID());
            System.out.println("Transfer successful!");
        }
    }

    private static void recordTransaction(User user, String transactionDetails) {
        user.addTransaction(transactionDetails);
    }
}
