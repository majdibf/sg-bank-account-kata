package org.kata.bank;

import java.time.LocalDate;

public class OperationBuilder {
    private OperationType operation;
    private LocalDate date;
    private double amount;
    private double balance;

    public OperationBuilder setOperation(OperationType operation) {
        this.operation = operation;
        return this;
    }

    public OperationBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public OperationBuilder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public OperationBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public Operation build() {
        return new Operation(operation, date, amount, balance);
    }
}
