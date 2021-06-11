package com.ecs.workshop.design.cleancode.domains;

public class DebitTransaction implements Transaction {

    public static DebitTransaction fromDebitAmount(Amount debitAmount, Amount resumeAmount) {
        return new DebitTransaction(debitAmount, resumeAmount);
    }

    private final Amount debitAmount;
    private final Amount resumeAmount;

    public DebitTransaction(Amount debitAmount, Amount resumeAmount) {
        this.debitAmount = debitAmount;
        this.resumeAmount = resumeAmount;
    }

    @Override
    public String describeTransaction() {
        return String.format(
            "Debit transaction value [%1$,.2f] from balance [%2$,.2f]",
            debitAmount.getValue().doubleValue(),
            resumeAmount.getValue().doubleValue());
    }
}
