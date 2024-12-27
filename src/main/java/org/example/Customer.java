package org.example;

public class Customer extends Thread {
    private final int customerId;
    private final Bank bank;
    private final int accountNumber;

    public Customer(int customerId, Bank bank, int accountNumber) {
        this.customerId = customerId;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.setName("Customer-" + customerId);
    }

    @Override
    public void run() {
        // Example sequence of transactions
        try {
            bank.deposit(accountNumber, 100);
            Thread.sleep((int) (Math.random() * 100));

            bank.withdraw(accountNumber, 50);
            Thread.sleep((int) (Math.random() * 100));

            bank.deposit(accountNumber, 200);
            Thread.sleep((int) (Math.random() * 100));

            bank.withdraw(accountNumber, 150);
        } catch (InterruptedException e) {
            System.err.println(this.getName() + " was interrupted.");
        }
    }
}
