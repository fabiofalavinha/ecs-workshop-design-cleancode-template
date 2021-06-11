package com.ecs.workshop.design.cleancode.domains;

import java.math.BigDecimal;

public final class AdministrativeTax {

    public static AdministrativeTax fromDouble(double value) {
        return new AdministrativeTax(BigDecimal.valueOf(value));
    }

    public static AdministrativeTax zero() {
        return new AdministrativeTax(BigDecimal.ZERO);
    }

    private final BigDecimal value;

    AdministrativeTax(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
