package com.ecs.workshop.design.cleancode.domains;

public class DefaultAccount extends AbstractAccount {

    private static final PercentualAdministrativeTax DEFAULT_TAX = PercentualAdministrativeTax.fromDouble(0.05d);

    DefaultAccount(Agency agency, Client client, Amount amount) {
        super(agency, client, amount);
    }

    @Override
    public AdministrativeTax getTax() {
        return DEFAULT_TAX;
    }
}
