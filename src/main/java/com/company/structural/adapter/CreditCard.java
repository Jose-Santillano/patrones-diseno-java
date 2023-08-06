package com.company.structural.adapter;

public class CreditCard implements Payment{

    Adapter adapter;

    @Override
    public void pay(String type) {
        if(type.equals("classic")){
            System.out.println("Tarjeta Classic sin seguridad.");
        }else if(type.equals("gold")){
            adapter = new Adapter("gold");
            adapter.pay("gold");
        } else if(type.equals("black")){
            adapter = new Adapter("black");
            adapter.pay("black");
        } else {
            System.out.println("No se puede realizar el pago. No se reconoce esa tarjeta.");
        }
    }
}