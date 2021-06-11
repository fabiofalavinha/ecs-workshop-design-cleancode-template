package com.ecs.workshop.design.cleancode.domains;

public class TransferFinancialOperation implements FinancialOperation {

    private final Account from;
    private final Account to;
    private final Amount theValue;

    public TransferFinancialOperation(Account from, Account to, Amount theValue) {
        this.from = from;
        this.to = to;
        this.theValue = theValue;
    }

    @Override
    public Receipt execute() {
        final Transaction debitTransaction = from.debit(this.theValue);
        final Transaction creditTransaction = this.to.credit(this.theValue);
        return TransferFinancialOperationReceipt.fromTransactions(debitTransaction, creditTransaction);
    }
}
