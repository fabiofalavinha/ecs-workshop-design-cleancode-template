package com.ecs.workshop.design.cleancode.domains;

public class DepositFinancialOperation implements FinancialOperation {

    private final Account to;
    private final Amount value;

    public DepositFinancialOperation(Account to, Amount value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public Receipt execute() {
        final Transaction creditTransaction = this.to.credit(this.value);
        return DepositFinancialOperationReceipt.fromCreditTransaction(creditTransaction);
    }
}
