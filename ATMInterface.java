import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static int balance = 5000;
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Interface!");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();
        boolean isAuthenticated = authenticateUser(userId, userPin);
        if (isAuthenticated) {
            System.out.println("Authentication successful!");
            showMainMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static boolean authenticateUser(String userId, String userPin) {
        return userId.equals(userPin);
    }

    private static void showMainMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: $");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    private static void transfer() {
        System.out.print("Enter the amount to transfer: $");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
