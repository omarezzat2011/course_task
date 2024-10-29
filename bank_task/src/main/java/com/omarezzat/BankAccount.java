package com.omarezzat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BankAccount implements InterestCalculable {
    private final long accountNumber;
    private final Customer customer;
    private final Bank bank;
    private double balance;

    @Override
    public double calculateInterest(double rate, int time) {
        return balance * rate * time / 100;
    }

}
