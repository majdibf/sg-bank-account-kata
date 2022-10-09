package org.kata.bank;

public class Account {

    double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public void withdraw() {

    }

    public void showHistory() {

    }

}
