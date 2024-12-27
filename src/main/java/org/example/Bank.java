package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final Map<Integer, Account> accounts;

    public Bank() {
        accounts = new ConcurrentHashMap<>();
    }

    /**
     * Adds a new account to the bank.
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    /**
     * Deposits the specified amount into the given account.
     *
     * @param accountNumber the account number
     * @param amount        the amount to deposit
     */
    public void deposit(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account " + accountNumber + " not found for deposit.");
        }
    }

    /**
     * Withdraws the specified amount from the given account.
     *
     * @param accountNumber the account number
     * @param amount        the amount to withdraw
     */
    public void withdraw(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            try {
                account.withdraw(amount);
            } catch (IllegalArgumentException e) {
                // Handle insufficient funds if necessary
            }
        } else {
            System.out.println("Account " + accountNumber + " not found for withdrawal.");
        }
    }

    /**
     * Retrieves the current balance of the specified account.
     *
     * @param accountNumber the account number
     * @return the current balance, or -1 if account not found
     */
    public int getBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account " + accountNumber + " not found for balance inquiry.");
            return -1;
        }
    }

    /**
     * Prints the balances of all accounts in the bank.
     */
    public void printAllBalances() {
        System.out.println("\nFinal account balances:");
        for (Account account : accounts.values()) {
            System.out.println("Account " + account.getAccountNumber() + ": $" + account.getBalance());
        }
    }
}
