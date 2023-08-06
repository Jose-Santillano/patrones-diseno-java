package com.company.behavioral.templatemethod;

public abstract class Payment {

    abstract void initialize();
    abstract void startPayment();
    abstract void endPayment();

    public final void makePayment(){
        //Orden de proceso abstracto.
        initialize();
        startPayment();
        endPayment();
    }
}
