package com.rev.starter_code.banking;

import java.util.HashMap;

public class Bank {
    HashMap<String, Account> accounts = new HashMap<>();

    public void openAccount(String id, double initialDeposit) throws InvalidAccountException {
        Account newAccount = new Account(id, initialDeposit);
        accounts.put(id, newAccount);
    }

    public Account getAccount(String id) throws InvalidAccountException {
        Account account = accounts.get(id);
        if (account == null) {
            throw new InvalidAccountException(id + " is not valid");
        }
        return account;
    }

    public void transfer(String fromId, String toId, double amount)
            throws InvalidAccountException, InsufficientFundsException {
        Account fromAccount = accounts.get(fromId);
        if (fromAccount == null) {
            throw new InvalidAccountException(fromId + " is not valid");
        }
        Account toAccount = accounts.get(toId);
        if (toAccount == null) {
            throw new InvalidAccountException(toId + " is not valid");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}