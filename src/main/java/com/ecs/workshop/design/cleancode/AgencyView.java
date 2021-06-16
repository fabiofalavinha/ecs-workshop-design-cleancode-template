package com.ecs.workshop.design.cleancode;

import com.ecs.workshop.design.cleancode.core.exceptions.BankErrorException;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AgencyView implements BankView {

    @Override
    public void showWarningMessage(BankErrorException error) {
        JOptionPane.showMessageDialog(
            null,
            error.getLocalizedMessage(),
            "ATENÇÃO",
            JOptionPane.WARNING_MESSAGE);
    }
}
