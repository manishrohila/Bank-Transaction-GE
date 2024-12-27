package org.example;

public class Account {
    private final int accountNumber;
    private int balance;

    public Account(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Deposits the specified amount into the account.
     * This method is synchronized to ensure thread safety.
     *
     * @param amount the amount to deposit
     */
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposited $" + amount + " to account " + accountNumber +
                ". New balance: $" + balance);
    }

    /**
     * Withdraws the specified amount from the account.
     * This method is synchronized to ensure thread safety.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if insufficient funds
     */
    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() +
                    " failed to withdraw $" + amount + " from account " + accountNumber +
                    ". Insufficient funds. Current balance: $" + balance);
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() +
                " withdrew $" + amount + " from account " + accountNumber +
                ". New balance: $" + balance);
    }

    /**
     * Returns the current balance of the account.
     * This method is synchronized to ensure visibility of the latest balance.
     *
     * @return the current balance
     */
    public synchronized int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
