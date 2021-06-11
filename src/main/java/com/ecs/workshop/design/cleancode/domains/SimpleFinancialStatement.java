package com.ecs.workshop.design.cleancode.domains;

public class SimpleFinancialStatement implements FinancialStatement {

    private final Account account;

    public SimpleFinancialStatement(Account account) {
        this.account = account;
    }

    @Override
    public String getInformativeText() {
        return String.format(
            "Account [%1$s] has current balance of [%2$,.2f]",
            String.join(" - ", account.getNumber().getValue(), account.getClient().getName()),
            account.getBalance().asDouble());
    }
}
