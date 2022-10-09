package org.kata.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    static final String HEADER = "| Operation | Date | Amount | Balance |";

    List<Operation> operations = new ArrayList<>();

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        Operation operation = new OperationBuilder().setOperation(OperationType.DEPOSIT).setAmount(amount).setDate(LocalDate.now()).setBalance(getNewBalance(amount)).build();
        operations.add(operation);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > getBalance()) {
            throw new IllegalArgumentException();
        }
        Operation operation = new OperationBuilder().setOperation(OperationType.WITHDRAW).setAmount(-amount).setDate(LocalDate.now()).setBalance(getNewBalance(-amount)).build();
        operations.add(operation);
    }

    public void showHistory(Printer printer) {
        printer.print(HEADER);
        operations.stream().forEach(operation -> printer.print(operation.toPrint()));
    }

    public double getBalance() {
        return operations.stream().mapToDouble(Operation::getAmount).sum();
    }

    public double getNewBalance(double amount) {
        return getBalance() + amount;
    }

}
