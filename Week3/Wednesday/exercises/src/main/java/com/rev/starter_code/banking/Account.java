package com.rev.starter_code.banking;


public class Account {
    private String id;
    private double balance;

    public Account(String id, double balance){
        this.id = id;
        this.balance = balance;
    } 

    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + balance + "]";
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0){
            throw new IllegalArgumentException("Can not deposit a negative amount!");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        if (amount > balance){
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }
}