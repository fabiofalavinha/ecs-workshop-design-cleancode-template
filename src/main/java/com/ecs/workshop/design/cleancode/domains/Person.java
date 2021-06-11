package com.ecs.workshop.design.cleancode.domains;

public class Person implements Client {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
