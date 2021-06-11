package com.ecs.workshop.design.cleancode.domains;

public final class AccountNumber {

    private static final int DEFAULT_LENGTH = 6;
    private static int INDEXER = 1;

    public static AccountNumber generateNumber() {
        return new AccountNumber();
    }

    private final int number;

    private AccountNumber() {
        this.number = INDEXER++;
    }

    public String getValue() {
        return padLeftZeros(String.valueOf(this.number), DEFAULT_LENGTH);
    }

    private String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);
        return sb.toString();
    }
}
