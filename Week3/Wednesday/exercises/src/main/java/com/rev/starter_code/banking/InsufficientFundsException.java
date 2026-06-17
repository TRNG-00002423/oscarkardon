package com.rev.starter_code.banking;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(double shortFallAmount) {
        super("Insufficient funds. Shortfall: $" + shortFallAmount);
    }
}