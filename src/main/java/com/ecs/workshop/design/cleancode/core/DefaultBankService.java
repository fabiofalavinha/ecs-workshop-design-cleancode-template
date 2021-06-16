package com.ecs.workshop.design.cleancode.core;

import com.ecs.workshop.design.cleancode.core.exceptions.OpenAccountFailedException;
import com.ecs.workshop.design.cleancode.domains.*;
import com.ecs.workshop.design.cleancode.persistence.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBankService implements BankService {

    private final Bank defaultBank;

    @Autowired
    public DefaultBankService(AccountRepository accountRepository) {
        defaultBank = new Bank(accountRepository);
    }

    @Override
    public Account openAccount(Client client) {
        try {
            return this.defaultBank.openAccount(client);
        } catch (IllegalArgumentException cause) {
            throw new OpenAccountFailedException(cause);
        }
    }

    @Override
    public Account openAccount(Client client, Amount amount) {
        try {
            return this.defaultBank.openAccount(client, amount);
        } catch (IllegalArgumentException cause) {
            throw new OpenAccountFailedException(cause);
        }
    }

    @Override
    public Receipt deposit(Account from, Amount amount) {
        return this.defaultBank.deposit(from, amount);
    }

    @Override
    public Receipt pay(Billet billet, Account account) {
        return this.defaultBank.pay(billet, account);
    }

    @Override
    public Receipt transferFunds(Account from, Account to, Amount amount) {
        return this.defaultBank.transferFunds(from, to, amount);
    }
}
