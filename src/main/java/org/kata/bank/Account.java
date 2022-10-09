package org.kata.bank;

public class Account {

    double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }

    public void showHistory() {

    }

}
