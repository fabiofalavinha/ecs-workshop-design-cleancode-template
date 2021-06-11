package com.ecs.workshop.design.cleancode.domains;

import java.math.BigDecimal;

public interface Account {

    Amount SPECIAL_ACCOUNT_BASE_LIMIT = Amount.of(BigDecimal.valueOf(10000d));

    Agency getAgency();
    AccountNumber getNumber();
    AdministrativeTax getTax();
    Client getClient();
    Transaction debit(Amount amount);
    Transaction credit(Amount amount);
    FinancialStatement describeStatement();
    Amount getBalance();
    Account addClient(Person person);

}
