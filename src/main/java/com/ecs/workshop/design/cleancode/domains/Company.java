package com.ecs.workshop.design.cleancode.domains;

public class Company implements Client {

    private final String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
