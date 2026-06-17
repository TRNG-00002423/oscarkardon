package com.rev.starter_code.banking;

public class BankingDemo {
    public static void main(String[] args) throws Exception {
        // TODO: demonstrate success path + catch InsufficientFundsException + InvalidAccountException
        // TODO: trigger IllegalArgumentException on bad deposit
        Bank bank = new Bank();

        try {
            bank.openAccount("Oscar", 500);
            bank.openAccount("Gray", 200);

            bank.transfer("Oscar", "Gray", 100);

            System.out.println(bank.getAccount("Oscar"));
            System.out.println(bank.getAccount("Gray"));

        } catch (InvalidAccountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try{
            Account account = bank.getAccount("Oscar");
            account.withdraw(10000);
        }
        catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

        try {
            bank.getAccount("wrongID");
        } catch (InvalidAccountException e) {
            System.out.println(e.getMessage());
        }

        

        try {
            bank.transfer("Oscar", "Gray", 100000000);
        } catch (InvalidAccountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.getAccount("Oscar").deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    
    }
}
