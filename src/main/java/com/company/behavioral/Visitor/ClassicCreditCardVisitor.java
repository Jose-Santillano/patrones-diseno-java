package com.company.behavioral.Visitor;

public class ClassicCreditCardVisitor implements  CreditCardVisitor{
    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        System.out.println("Descuento del 3% en gasolina con tarjeta clasica.");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        System.out.println("Descuento del 5% en gasolina con tarjeta clasica.");
    }
}
