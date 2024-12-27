package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Initialize accounts
        int[] accountNumbers = {1001, 1002, 1003};
        for (int accNum : accountNumbers) {
            bank.addAccount(new Account(accNum, 1000)); // Each account starts with $1000
        }

        // Create customers
        Customer customer1 = new Customer(1, bank, 1001);
        Customer customer2 = new Customer(2, bank, 1002);
        Customer customer3 = new Customer(3, bank, 1003);
        Customer customer4 = new Customer(4, bank, 1001);
        Customer customer5 = new Customer(5, bank, 1002);

        // Start customer threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        // Wait for all customers to finish
        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }

        // Print final balances
        bank.printAllBalances();
    }
}