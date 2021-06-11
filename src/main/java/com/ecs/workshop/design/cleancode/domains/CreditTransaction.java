package com.ecs.workshop.design.cleancode.domains;

public class CreditTransaction implements Transaction {

    public static CreditTransaction fromCreditAmount(Amount debitAmount, Amount resumeAmount) {
        return new CreditTransaction(debitAmount, resumeAmount);
    }

    private final Amount creditAmount;
    private final Amount resumeAmount;

    public CreditTransaction(Amount debitAmount, Amount resumeAmount) {
        this.creditAmount = debitAmount;
        this.resumeAmount = resumeAmount;
    }

    @Override
    public String describeTransaction() {
        return String.format(
            "Credit transaction value [%1$,.2f] to balance [%2$,.2f]",
            creditAmount.getValue().doubleValue(),
            resumeAmount.getValue().doubleValue());
    }

}
