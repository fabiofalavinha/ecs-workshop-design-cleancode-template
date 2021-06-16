package com.ecs.workshop.design.cleancode.view;

import com.ecs.workshop.design.cleancode.core.exceptions.BankErrorException;

public interface BankView {

    void showWarningMessage(BankErrorException error);

}
