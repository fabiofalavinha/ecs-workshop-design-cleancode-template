package com.ecs.workshop.design.cleancode.domains;

import java.util.HashSet;
import java.util.Set;

public final class Bank {

    private static Bank instance;

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    private final Agency agency;
    private final Set<Account> accountSet;

    private Bank() {
        this.agency = Agency.newAgency();
        this.accountSet = new HashSet<>();
    }

    public Agency getAgency() {
        return this.agency;
    }

    public Account openAccount(Client client) {
        return this.openAccount(client, Amount.fromZero());
    }

    public Account openAccount(Client client, Amount amount) {
        if (client == null) {
            throw new IllegalArgumentException("Não é possível abrir uma conta sem um cliente definido");
        }

        if (amount == null) {
            amount = Amount.fromZero();
        } else {
            if (amount.isLessThanZero()) {
                throw new IllegalArgumentException("Não é possível abrir uma conta com valor negativo");
            }
        }

        final Account account;

        if (amount.isEqualsAndGreaterThan(Account.SPECIAL_ACCOUNT_BASE_LIMIT)) {
            account = new SpecialAccount(this.getAgency(), client, amount);
        } else {
            account = new DefaultAccount(this.getAgency(), client, amount);
        }

        this.accountSet.add(account);

        return account;
    }

    public Receipt deposit(Account to, Amount amount) {
        if (amount.isLessThanZero()) {
            throw new IllegalArgumentException("Valor inválido. Não é possível depositar um valor negativo.");
        }
        final FinancialOperation deposit = new DepositFinancialOperation(to, amount);
        return deposit.execute();
    }

    public Receipt pay(Billet billet, Account from) {
        final FinancialOperation payBillet = new BilletFinancialOperation(from, billet);
        return payBillet.execute();
    }

    public Receipt transferFunds(Account from, Account to, Amount amount) {
        final FinancialOperation transfer = new TransferFinancialOperation(from, to, amount);
        return transfer.execute();
    }
}
