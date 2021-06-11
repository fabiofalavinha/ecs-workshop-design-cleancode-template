package com.ecs.workshop.design.cleancode.domains;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractAccount implements Account {

    private final AccountNumber accountNumber;
    private final Client principal;
    private final Agency agency;
    private final SimpleFinancialStatement financialStatement;
    private final Set<Person> others;

    protected Amount balance;

    AbstractAccount(Agency agency, Client principal, Amount amount) {
        this.agency = agency;
        this.accountNumber = AccountNumber.generateNumber();
        this.principal = principal;
        this.balance = amount;
        this.financialStatement = new SimpleFinancialStatement(this);
        this.others = new HashSet<>();
    }

    @Override
    public abstract AdministrativeTax getTax();

    @Override
    public Agency getAgency() {
        return this.agency;
    }

    @Override
    public AccountNumber getNumber() {
        return this.accountNumber;
    }

    @Override
    public Client getClient() {
        return this.principal;
    }

    @Override
    public Transaction debit(Amount amount) {
        this.balance = this.balance.subtract(amount);
        this.balance = this.balance.subtractPercentual(this.getTax());
        return DebitTransaction.fromDebitAmount(amount, this);
    }

    @Override
    public Transaction credit(Amount amount) {
        this.balance = this.balance.add(amount);
        return CreditTransaction.fromCreditAmount(amount, this);
    }

    @Override
    public FinancialStatement describeStatement() {
        return this.financialStatement;
    }

    @Override
    public Amount getBalance() {
        return this.balance;
    }

    public Account addClient(Person person) {
        this.others.add(person);
        return this;
    }
}
