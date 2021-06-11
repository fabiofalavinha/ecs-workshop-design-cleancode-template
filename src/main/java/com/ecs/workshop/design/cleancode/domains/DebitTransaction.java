package com.ecs.workshop.design.cleancode.domains;

public class DebitTransaction implements Transaction {

    public static DebitTransaction fromDebitAmount(Amount amount, Account account) {
        return new DebitTransaction(amount, account);
    }

    private final Amount debitAmount;
    private final Account account;

    private DebitTransaction(Amount debitAmount, Account account) {
        this.debitAmount = debitAmount;
        this.account = account;
    }

    @Override
    public String describeTransaction() {
        return String.format(
            "Debit [%1$,.2f] with tax [%2$,.2f] from account [%3$s] with current balance of [%4$,.2f]",
            debitAmount.asDouble(),
            account.getTax().getTaxValue().asDouble(),
            String.join(" - ", account.getNumber().getValue(), account.getClient().getName()),
            account.getBalance().asDouble());
    }
}
