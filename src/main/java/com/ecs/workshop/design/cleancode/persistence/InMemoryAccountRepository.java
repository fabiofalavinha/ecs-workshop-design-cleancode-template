package com.ecs.workshop.design.cleancode.persistence;

import com.ecs.workshop.design.cleancode.domains.Account;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private final Set<Account> accountSet;

    public InMemoryAccountRepository() {
        accountSet = new HashSet<>();
    }

    @Override
    public void save(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account must be not null");
        }
        this.accountSet.add(account);
    }

    @Override
    public Account[] getAccounts() {
        return this.accountSet.toArray(new Account[] {});
    }
}
