package com.ecs.workshop.design.cleancode.domains;

public final class TransferFinancialOperationReceipt implements Receipt {

    public static TransferFinancialOperationReceipt fromTransactions(Transaction debitTransaction, Transaction creditTransaction) {
        return new TransferFinancialOperationReceipt(debitTransaction, creditTransaction);
    }

    private final Transaction debitTransaction;
    private final Transaction creditTransaction;

    private TransferFinancialOperationReceipt(Transaction debitTransaction, Transaction creditTransaction) {
        this.debitTransaction = debitTransaction;
        this.creditTransaction = creditTransaction;
    }

    @Override
    public String getInformativeText() {
        return String.join(", ", debitTransaction.describeTransaction(), creditTransaction.describeTransaction());
    }
}
