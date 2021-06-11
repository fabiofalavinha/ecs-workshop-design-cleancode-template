package com.ecs.workshop.design.cleancode.domains;

import java.math.BigDecimal;

public final class PercentualAdministrativeTax implements AdministrativeTax {

    public static PercentualAdministrativeTax fromDouble(double value) {
        return new PercentualAdministrativeTax(BigDecimal.valueOf(value));
    }

    public static PercentualAdministrativeTax zero() {
        return new PercentualAdministrativeTax(BigDecimal.ZERO);
    }

    private final BigDecimal tax;

    PercentualAdministrativeTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Amount getTaxValue() {
        return Amount.of(this.tax);
    }

    @Override
    public Amount apply(Amount value) {
        final BigDecimal diff = value.getValue().multiply(this.tax);
        return value.subtract(Amount.of(diff));
    }
}
