package com.rev.starter_code.money;

import java.util.Objects;


public final class Money {
    private final String currency;
    private final long amountMinor;

    public Money(String currency, long amountMinor){
        if(currency == null){
            throw new IllegalArgumentException("Currency cannot be null");
        }
        this.currency = currency;
        this.amountMinor = amountMinor;
    }

    public String getCurrency() {
        return currency;
    }

    public long getAmountMinor() {
        return amountMinor;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        Money other = (Money) o;
        return currency.equals(other.getCurrency()) && amountMinor == other.getAmountMinor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amountMinor);
    }

    @Override
    public String toString() {
        return currency + " " + amountMinor;
    }
}