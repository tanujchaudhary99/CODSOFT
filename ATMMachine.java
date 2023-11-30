import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current Balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Please enter a smaller amount or deposit funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

public class ATMMachine {
    private BankAccount account;

    public ATMMachine(BankAccount account) {
        this.account = account;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Machine Options:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Starting with an initial balance of $1000
        ATMMachine atm = new ATMMachine(userAccount);
        atm.startATM();
    }
}

