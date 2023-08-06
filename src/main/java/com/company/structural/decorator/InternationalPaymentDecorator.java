package com.company.structural.decorator;

public class InternationalPaymentDecorator extends CreditDecorator{
    public InternationalPaymentDecorator(Credit decorateCredit) {
        super(decorateCredit);
    }

    @Override
    public void showCredit() {
        decorateCredit.showCredit();
        configInternationalPayment();
    }

    private void configInternationalPayment(){
        System.out.println("La tarjeta se configuro para pagos internacionales.");
    }
}
