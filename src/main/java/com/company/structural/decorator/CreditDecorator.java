package com.company.structural.decorator;

public class CreditDecorator implements Credit{

    protected Credit decorateCredit;

    public CreditDecorator(Credit decorateCredit) {
        this.decorateCredit = decorateCredit;
    }

    @Override
    public void showCredit() {
        decorateCredit.showCredit();
    }
}
