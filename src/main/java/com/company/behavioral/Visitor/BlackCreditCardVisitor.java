package com.company.behavioral.Visitor;

public class BlackCreditCardVisitor implements  CreditCardVisitor{
    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        System.out.println("Descuento del 10% en gasolina con tarjeta Black.");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        System.out.println("Descuento del 25% en gasolina con tarjeta Black.");
    }
}
