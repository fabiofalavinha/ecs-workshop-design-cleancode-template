package com.ecs.workshop.design.cleancode.domains;

public class SpecialAccount extends AbstractAccount {

    private static final PercentualAdministrativeTax DEFAULT_TAX = PercentualAdministrativeTax.zero();

    SpecialAccount(Agency agency, Client client, Amount amount) {
        super(agency, client, amount);
    }

    @Override
    public AdministrativeTax getTax() {
        return DEFAULT_TAX;
    }
}
