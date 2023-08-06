package com.company.structural.adapter;

public class BlackCreditCard implements Secure{
    @Override
    public void payWithSecureLevelA() {
        System.out.println("Tarjeta Black: Pagando con seguridad alta Nivel A.");
    }

    @Override
    public void payWithSecureLevelZ() {
        //No implementar.
    }
}
