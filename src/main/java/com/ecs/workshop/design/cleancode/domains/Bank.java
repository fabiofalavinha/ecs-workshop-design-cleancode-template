package com.ecs.workshop.design.cleancode.domains;

import com.ecs.workshop.design.cleancode.persistence.AccountRepository;

public final class Bank {

    private final Agency agency;
    private final AccountRepository accountRepository;

    public Bank(AccountRepository accountRepository) {
        this.agency = Agency.newAgency();
        this.accountRepository = accountRepository;
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

        this.accountRepository.save(account);

        return account;
    }

    public Receipt deposit(Account to, Amount amount) {
        if (amount.isZero() || amount.isLessThanZero()) {
            throw new IllegalArgumentException("Valor inválido. Não é possível depositar um valor menor/igual a zero.");
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
