package com.ecs.workshop.design.cleancode.domains;

import java.math.BigDecimal;

public final class Amount {

    public static Amount fromZero() {
        return new Amount(BigDecimal.ZERO);
    }

    public static Amount of(double value) {
        return new Amount(BigDecimal.valueOf(value));
    }

    public static Amount of(BigDecimal value) {
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        return new Amount(value);
    }

    private final BigDecimal value;

    Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public boolean isEqualsAndGreaterThan(Amount amount) {
        return value.compareTo(amount.getValue()) >= 0;
    }

    public boolean isLessThanZero() {
        return value.compareTo(BigDecimal.ZERO) < 0;
    }

    public Amount subtract(Amount amount) {
        return Amount.of(this.value.subtract(amount.getValue()));
    }

    public Amount add(Amount amount) {
        return Amount.of(this.value.add(amount.getValue()));
    }

    public Amount subtractPercentual(AdministrativeTax tax) {
        final BigDecimal percentualValue = this.value.multiply(tax.getValue());
        return Amount.of(this.value.subtract(percentualValue));
    }

    public boolean isZero() {
        return this.value.equals(BigDecimal.ZERO);
    }
}
