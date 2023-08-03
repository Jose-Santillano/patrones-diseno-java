package com.company.creational.factorymethod;

//CONCRETED PRODUCT.
public class CardPayment implements Payment{
    @Override
    public void doPayment() {
        System.out.println("Pagando con tarjeta de crédito.");
    }
}
