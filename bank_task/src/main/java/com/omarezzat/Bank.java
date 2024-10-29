package com.omarezzat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Bank {
    private final String name;

    private void deposit(BankAccount bankAccount, double amount) {
        bankAccount.setBalance(bankAccount.getBalance() + amount);

    }
    private void withdraw(BankAccount bankAccount, double amount) throws RuntimeException {
        if(bankAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");

        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
    }
    private double balanceInquiry(BankAccount bankAccount) {
        return bankAccount.getBalance();
    }
    public void applyInterest(BankAccount bankAccount ,int interestRate,int time) {
        double interest = bankAccount.calculateInterest(interestRate, time);
        this.deposit(bankAccount,interest);
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Bank");

        Customer c1 = new Customer("omar", "ezzar","01027391470");
        Customer c2 = new Customer("omar3", "ezzar3","01027391471");
        Customer c3 = new Customer("omar2", "ezzar2","01027391472");

        BankAccount b1 = new BankAccount(1L , c1, bank);
        BankAccount b2 = new BankAccount(2L , c2, bank);
        BankAccount b3 = new BankAccount(3L , c3, bank);

        bank.deposit(b1,100);
        bank.deposit(b2,350);
        bank.deposit(b3,150);

        bank.applyInterest(b1,20,2);
        System.out.println(bank.balanceInquiry(b1));;



    }
}
