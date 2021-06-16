package com.ecs.workshop.design.cleancode;

import com.ecs.workshop.design.cleancode.core.exceptions.BankErrorException;

public interface BankView {

    void showWarningMessage(BankErrorException error);

}
