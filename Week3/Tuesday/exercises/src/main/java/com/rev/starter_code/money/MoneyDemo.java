package com.rev.starter_code.money;


import java.util.HashSet;
import java.util.Set;

public class MoneyDemo {
    public static void main(String[] args) {
        // TODO: build Money USD 1000 cents twice, add to HashSet, print size
        // TODO: print equals vs ==

        Money usd = new Money("USD", 1000);
        Money usd2 = new Money("USD", 1000);
        HashSet<Money> currencies = new HashSet<>();
        currencies.add(usd);
        currencies.add(usd2);
        System.out.println("Currencies HashSet size: " + currencies.size());
        System.out.println("usd == usd2: " + (usd == usd2));
        System.out.println("usd.equals(usd2): " + usd.equals(usd2));
    }
}