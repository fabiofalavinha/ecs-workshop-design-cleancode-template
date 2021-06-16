package com.ecs.workshop.design.cleancode.core;

import com.ecs.workshop.design.cleancode.BankView;
import com.ecs.workshop.design.cleancode.core.exceptions.BankErrorException;
import org.springframework.stereotype.Component;

@Component("agencyView")
public class AgencyView implements BankView {

    @Override
    public void showWarningMessage(BankErrorException error) {

    }
}
