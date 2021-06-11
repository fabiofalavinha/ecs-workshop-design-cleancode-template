package com.ecs.workshop.design.cleancode.domains;

public class DefaultAccount extends AbstractAccount {

    private static final AdministrativeTax DEFAULT_TAX = AdministrativeTax.fromDouble(0.05d);

    DefaultAccount(Agency agency, Client client, Amount amount) {
        super(agency, client, amount);
    }

    @Override
    public AdministrativeTax getTax() {
        return DEFAULT_TAX;
    }
}
