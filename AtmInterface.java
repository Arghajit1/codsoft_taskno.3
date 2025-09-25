package AtmInterface;

import java.util.Scanner;


class BankAccount {
    private double balance;

  
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

   
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            System.out.println(" Invalid withdrawal amount!");
        }
    }

   
    public double getBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;
    private Scanner sc;


    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

   
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performWithdraw();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    
    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }


    private void performDeposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

  
    private void performCheckBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }
}


public class AtmInterface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount(2000.0);

        // Create ATM linked with that account
        ATM atm = new ATM(myAccount);

        // Show ATM menu
        atm.showMenu();
    }
}

