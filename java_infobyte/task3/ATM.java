package task3;
public class ATM {
    private Bank bank;
    private User currentUser;

    public ATM() {
        bank = new Bank();
        // Initialize with some users
        bank.addUser(new User("user1", "1111", 1000.0));
        bank.addUser(new User("user2", "2222", 2000.0));
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.login();
    }

    public void login() {
        // Simulate user login
        ATMInterface.displayLogin();
        String userID = ATMInterface.getUserInput("Enter User ID: ");
        String userPIN = ATMInterface.getUserInput("Enter PIN: ");

        currentUser = bank.validateUser(userID, userPIN);
        if (currentUser != null) {
            showMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    public void showMenu() {
        while (true) {
            ATMInterface.displayMenu();
            int choice = Integer.parseInt(ATMInterface.getUserInput("Enter your choice: "));
            performOperation(choice);
            if (choice == 5) break;
        }
    }

    public void performOperation(int choice) {
        switch (choice) {
            case 1:
                ATMInterface.showTransactionHistory(currentUser);
                break;
            case 2:
                ATMInterface.promptWithdraw(currentUser);
                break;
            case 3:
                ATMInterface.promptDeposit(currentUser);
                break;
            case 4:
                ATMInterface.promptTransfer(currentUser, bank);
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
