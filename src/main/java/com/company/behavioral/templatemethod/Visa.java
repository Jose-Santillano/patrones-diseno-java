package com.company.behavioral.templatemethod;

public class Visa extends  Payment{
    @Override
    void initialize() {
        System.out.println("Inicializando pago Visa...");
    }

    @Override
    void startPayment() {
        System.out.println("Realizando pago con Visa...");
    }

    @Override
    void endPayment() {
        System.out.println("Finalizando pago Visa...");
    }
}
