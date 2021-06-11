package com.ecs.workshop.design.cleancode.domains;

public class CreditTransaction implements Transaction {

    public static CreditTransaction fromCreditAmount(Amount debitAmount, Account account) {
        return new CreditTransaction(debitAmount, account);
    }

    private final Amount creditAmount;
    private final Account account;

    private CreditTransaction(Amount debitAmount, Account account) {
        this.creditAmount = debitAmount;
        this.account = account;
    }

    @Override
    public String describeTransaction() {
        return String.format(
            "Credit [%1$,.2f] to account [%2$s] with current balance of [%3$,.2f]",
            creditAmount.getValue().doubleValue(),
            String.join(" - ", account.getNumber().getValue(), account.getClient().getName()),
            account.getBalance().getValue().doubleValue());
    }

}
