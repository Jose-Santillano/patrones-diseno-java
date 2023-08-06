package com.company.structural.decorator;

public class SecureDecorator extends CreditDecorator{

    public SecureDecorator(Credit decorateCredit) {
        super(decorateCredit);
    }

    @Override
    public void showCredit() {
        decorateCredit.showCredit();
        configureSecure();
    }

    private void configureSecure(){
        System.out.println("La tarjeta se configuro con seguridad maxima.");
    }
}
