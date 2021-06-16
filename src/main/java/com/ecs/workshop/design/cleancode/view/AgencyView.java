package com.ecs.workshop.design.cleancode.view;

import com.ecs.workshop.design.cleancode.core.exceptions.BankErrorException;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AgencyView implements BankView {

    @Override
    public void showWarningMessage(BankErrorException error) {
        final JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(error.getLocalizedMessage());

        final JDialog dialog = optionPane.createDialog(null, "ATENÇÃO");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
