package com.ecs.workshop.design.cleancode.domains;

public class DepositFinancialOperationReceipt implements Receipt {

    private final Transaction creditTransaction;

    public static Receipt fromCreditTransaction(Transaction creditTransaction) {
        return new DepositFinancialOperationReceipt(creditTransaction);
    }

    private DepositFinancialOperationReceipt(Transaction creditTransaction) {
        this.creditTransaction = creditTransaction;
    }

    @Override
    public String getInformativeText() {
        return creditTransaction.describeTransaction();
    }
}
