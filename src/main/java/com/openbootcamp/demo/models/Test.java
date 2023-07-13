package com.openbootcamp.demo.models;


public class Test {
    private String name;
    private double number = Math.random();

    public Test() {}

    public Test(String name) {
        this.name = name;
        this.number = Math.random();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // La biblioteca de serialización JSON (probablemente utilizada por el framework web de Spring)
    // se basa en getters y setters para determinar los campos que se deben incluir en la representación JSON
    // de un objeto.
    public double getNumber() {
        return number;
    }
}
