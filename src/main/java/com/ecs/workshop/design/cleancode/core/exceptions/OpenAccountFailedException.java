package com.ecs.workshop.design.cleancode.core.exceptions;

public class OpenAccountFailedException extends BankErrorException {

    public OpenAccountFailedException(IllegalArgumentException cause) {
        super(cause);
    }

}
