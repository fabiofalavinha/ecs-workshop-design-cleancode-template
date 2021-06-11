package com.ecs.workshop.design.cleancode.domains;

public class SimpleFinancialStatement implements FinancialStatement {

    private final Account account;

    public SimpleFinancialStatement(Account account) {
        this.account = account;
    }

    @Override
    public String getInformativeText() {
        return String.format(
            "Account [%s] has current balance of [%2$,.2f]",
            account.getNumber().getValue(),
            account.getBalance().getValue().doubleValue());
    }
}
