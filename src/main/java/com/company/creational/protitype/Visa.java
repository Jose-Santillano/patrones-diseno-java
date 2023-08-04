package com.company.creational.protitype;

public class Visa implements PrototypeCard{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    //20 atribtos más.

    @Override
    public void getCard() {
        System.out.println("Esto es una tarjeta Visa.");
    }

    @Override
    public PrototypeCard clone() throws CloneNotSupportedException {
        System.out.println("Clonando tarjeta Visa...");
        return (Visa) super
                .clone();
    }
}
