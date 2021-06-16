package com.ecs.workshop.design.cleancode.core;

import com.ecs.workshop.design.cleancode.domains.*;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    Account openAccount(Client client);
    Account openAccount(Client client, Amount amount);
    Receipt deposit(Account from, Amount amount);
    Receipt pay(Billet billet, Account account);
    Receipt transferFunds(Account from, Account to, Amount amount);

}
