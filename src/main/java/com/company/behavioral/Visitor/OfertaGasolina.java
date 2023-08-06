package com.company.behavioral.Visitor;

public class OfertaGasolina implements OfertaElement{
    @Override
    public void accept(CreditCardVisitor visitor) {
        visitor.ofertaGasolina(this);
    }
}
