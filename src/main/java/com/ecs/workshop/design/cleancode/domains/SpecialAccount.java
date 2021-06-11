package com.ecs.workshop.design.cleancode.domains;

public class SpecialAccount extends AbstractAccount {

    private static final AdministrativeTax DEFAULT_TAX = AdministrativeTax.zero();

    SpecialAccount(Agency agency, Client client, Amount amount) {
        super(agency, client, amount);
    }

    @Override
    public AdministrativeTax getTax() {
        return DEFAULT_TAX;
    }

    @Override
    public Transaction debit(Amount amount) {
        final Amount resumeAmount = this.balance;
        this.balance = this.balance.subtract(amount);
        return DebitTransaction.fromDebitAmount(amount, resumeAmount);
    }
}
