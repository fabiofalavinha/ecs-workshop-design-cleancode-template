package com.ecs.workshop.design.cleancode.domains;

import java.time.LocalDate;
import java.util.UUID;

public final class Billet {

    public static Billet generateWith(Account target, Amount amount, LocalDate dueDate) {
        return new Billet(target, amount, dueDate);
    }

    private final UUID code;
    private final Account target;
    private final Amount amount;
    private final LocalDate dueDate;

    private Billet(Account target, Amount amount, LocalDate dueDate) {
        this.code = UUID.randomUUID();
        this.target = target;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public boolean expired() {
        return LocalDate.now().isAfter(dueDate);
    }

    public Amount getAmount() {
        return this.amount;
    }

    public Account getTarget() {
        return this.target;
    }

    public String getCode() {
        return code.toString();
    }
}
