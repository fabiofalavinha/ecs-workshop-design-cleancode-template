package com.ecs.workshop.design.cleancode.persistence;

import com.ecs.workshop.design.cleancode.domains.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {

    Account[] getAccounts();
    void save(Account account);

}
