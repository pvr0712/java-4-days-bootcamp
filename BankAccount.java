package day3;

import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

   
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited rupees " + amount + " to " + accountHolder + "'s account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew rupees " + amount + " from " + accountHolder + "'s account.");
        } else {
            System.out.println("Insufficient balance for " + accountHolder + " to withdraw rupees " + amount);
        }
    }

    public void displayDetails() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: rupees" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Details for Account 1");
        System.out.print("Enter Account Holder Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum1 = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance1 = scanner.nextDouble();
        scanner.nextLine(); 

        BankAccount account1 = new BankAccount(name1, accNum1, balance1);

        System.out.println("\nEnter Details for Account 2");
        System.out.print("Enter Account Holder Name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum2 = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance2 = scanner.nextDouble();

        BankAccount account2 = new BankAccount(name2, accNum2, balance2);

        
        System.out.println("\nDeposits");
        System.out.print("Enter deposit amount for " + account1.accountHolder + ": ");
        double dep1 = scanner.nextDouble();
        account1.deposit(dep1);

        System.out.print("Enter deposit amount for " + account2.accountHolder + ": ");
        double dep2 = scanner.nextDouble();
        account2.deposit(dep2);

        System.out.println("\nWithdrawal");
        System.out.print("Enter withdrawal amount for " + account1.accountHolder + ": ");
        double withdrawAmount = scanner.nextDouble();
        account1.withdraw(withdrawAmount);

        System.out.println("\nUpdated Account Details");
        account1.displayDetails();
        account2.displayDetails();

        scanner.close();
    }
}