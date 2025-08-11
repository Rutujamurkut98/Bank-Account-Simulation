import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String dateTime = getCurrentDateTime();
            transactions.add("Credited: ₹" + amount + " on " + dateTime);
            System.out.println("Amount ₹ :"+amount + " credited successfully on " + dateTime);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String dateTime = getCurrentDateTime();
            transactions.add("Debited: ₹" + amount + " on " + dateTime);
            System.out.println("Amount ₹" + amount + " debited successfully on " + dateTime);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\nTransaction History:");
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
