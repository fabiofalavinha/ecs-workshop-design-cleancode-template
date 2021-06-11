package com.ecs.workshop.design.cleancode.domains;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BilletFinancialOperationReceipt implements Receipt {

    private final Billet billet;
    private final Transaction debitTransaction;
    private final Transaction creditTransaction;
    private final LocalDate paid;

    private BilletFinancialOperationReceipt(
        Billet billet,
        Transaction debitTransaction,
        Transaction creditTransaction,
        LocalDate paid) {
        this.billet = billet;
        this.debitTransaction = debitTransaction;
        this.creditTransaction = creditTransaction;
        this.paid = paid;
    }

    public static BilletFinancialOperationReceipt fromPayableBillet(
        Billet billet,
        Transaction debitTransaction,
        Transaction creditTransaction,
        LocalDate paid) {
        return new BilletFinancialOperationReceipt(billet, debitTransaction, creditTransaction, paid);
    }

    @Override
    public String getInformativeText() {
        return String.format(
            "Billet [%s] paid to [%s] at [%s] (%s)",
            billet.getCode(),
            billet.getTarget().getClient().getName(),
            paid.format(DateTimeFormatter.BASIC_ISO_DATE),
            String.join(",", debitTransaction.describeTransaction(), creditTransaction.describeTransaction()));
    }
}
