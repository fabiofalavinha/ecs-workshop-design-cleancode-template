package com.ecs.workshop.design.cleancode.domains;

import java.time.LocalDate;

public class BilletFinancialOperation implements FinancialOperation {

    private final Account from;
    private final Billet billet;

    public BilletFinancialOperation(Account from, Billet billet) {
        this.from = from;
        this.billet = billet;
    }

    @Override
    public Receipt execute() {
        if (billet.expired()) {
            throw new IllegalStateException("Entre em contato com sua agência para emitir 2a via do Boleto");
        }
        final Amount billetAmount = billet.getAmount();
        final Transaction debitTransaction = from.debit(billetAmount);
        final Account target = billet.getTarget();
        final Transaction creditTransaction = target.credit(billetAmount);
        return BilletFinancialOperationReceipt.fromPayableBillet(
            billet, debitTransaction, creditTransaction, LocalDate.now());
    }
}
