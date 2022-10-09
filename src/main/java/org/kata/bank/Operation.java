package org.kata.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operation {
    private OperationType operationType;
    private LocalDate date;
    private double amount;
    private double balance;

    public Operation(OperationType operation, LocalDate date, double amount, double balance) {
        this.operationType = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public String toPrint() {
        return String.format("| %s | %s | %s | %s |",
                operationType.toString(),
                date.format(DateTimeFormatter.ISO_DATE),
                amount,
                balance);
    }
}
