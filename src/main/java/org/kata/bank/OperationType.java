package org.kata.bank;

public enum OperationType {
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");

    private String operationName;

    OperationType(String operationName) {
        this.operationName = operationName;
    }
}
