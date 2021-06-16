package com.ecs.workshop.design.cleancode.core.exceptions;

public abstract class BankErrorException extends RuntimeException {

    public BankErrorException(Throwable cause) {
        super(cause);
    }
}
