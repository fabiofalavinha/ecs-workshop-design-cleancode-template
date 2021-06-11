package com.ecs.workshop.design.cleancode.domains;

public interface AdministrativeTax {

    Amount apply(Amount value);
    Amount getTaxValue();

}
