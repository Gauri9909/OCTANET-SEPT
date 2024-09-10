import java.util.Scanner;
public class ATMSimulation2 {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        double balance = 1000.0;  // Initial balance
        int pin = 1234;           // Initial PIN
        String history = "";      // Transaction history
        
        // Simple ATM menu loop
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Check Balance
                    System.out.println("Balance: $" + balance);
                    break;

                case 2: // Withdraw Cash
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw <= balance && withdraw > 0) {
                        balance -= withdraw;
                        System.out.println("Withdrew: $" + withdraw);
                        history += "Withdrew: $" + withdraw + "\n";
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;

                case 3: // Deposit Cash
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposited: $" + deposit);
                        history += "Deposited: $" + deposit + "\n";
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 4: // Change PIN
                    System.out.print("Enter current PIN: ");
                    int oldPin = scanner.nextInt();
                    if (oldPin == pin) {
                        System.out.print("Enter new PIN: ");
                        pin = scanner.nextInt();
                        System.out.println("PIN changed successfully!");
                    } else {
                        System.out.println("Incorrect PIN.");
                    }
                    break;

                case 5: // Transaction History
                    System.out.println("Transaction History:");
                    System.out.println(history.isEmpty() ? "No transactions yet." : history);
                    break;

                case 6: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}