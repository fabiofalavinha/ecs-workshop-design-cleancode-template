package com.ecs.workshop.design.cleancode.domains;

public class SpecialAccount extends AbstractAccount {

    private static final AdministrativeTax DEFAULT_TAX = AdministrativeTax.zero();

    SpecialAccount(Agency agency, Client client, Amount amount) {
        super(agency, client, amount);
    }

    @Override
    public AdministrativeTax getTax() {
        return DEFAULT_TAX;
    }
}
