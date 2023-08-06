package com.company.behavioral.Visitor;

public class OfertaVuelos implements OfertaElement{
    @Override
    public void accept(CreditCardVisitor visitor) {
        visitor.ofertaVuelos(this);
    }
}
