package com.company.creational.factorymethod;

//CONCRETED PRODUCT.
public class GooglePayment implements Payment{
    @Override
    public void doPayment() {
        System.out.println("Pagando con Google Payment.");
    }
}
