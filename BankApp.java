import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("1001", "Rutuja");

        while (true) {
            System.out.println("\n<... BANK MENU ...>");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1–5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    try {
                        double depositAmount = Double.parseDouble(sc.nextLine());
                        account.deposit(depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid amount.");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    try {
                        double withdrawAmount = Double.parseDouble(sc.nextLine());
                        account.withdraw(withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    account.printTransactions();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for banking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select between 1–5.");
            }
        }
    }
}
