package com.company;

import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.creational.abstractfactory.AbstractFactory;
import com.company.creational.abstractfactory.Card;
import com.company.creational.abstractfactory.FactoryProvider;
import com.company.creational.abstractfactory.PaymentMethod;
import com.company.creational.factorymethod.Payment;
import com.company.creational.factorymethod.PaymentFactory;
import com.company.creational.factorymethod.TypePayment;
import com.company.creational.protitype.PrototypeCard;
import com.company.creational.protitype.PrototypeFactory;

import static com.company.creational.protitype.PrototypeFactory.CartType.AMEX;
import static com.company.creational.protitype.PrototypeFactory.CartType.VISA;

public class Main {
    public static void main(String[] args) {

        //PATRONES CREACIONALES.
        //#1
        //probarFactoryMethod();
        //#2
        //probarAbstractFactoryMethod();
        //#3
        //probarBuilder();
        //#4
        //probarPrototype();
        //#5
        //probarSinglenton();

        //PATRONES DE COMPORTAMIENTO
        //#6
        probarChainOfResponsability();
    }

    //#1
    private static void probarFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }

    //#2
    private static void probarAbstractFactoryMethod(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");

        System.out.println("Una tarjeta de tipo: " + tarjeta.getCardType() + " con el método de pago: " + paymentMethod.doPayment());
    }

    //#3
    public static void probarBuilder(){
        com.company.creational.builder.Card card = new com.company.creational.builder.Card.CardBuilder("VISA",
                "0000 1111 2222 3333")
                .name("Alberto")
                .expires(2030)
                .credit(true)
                .build();

        System.out.println("card = " + card);

        com.company.creational.builder.Card card2 = new com.company.creational.builder.Card.CardBuilder("VISA",
                "0000 9999 9999 9999")
                .build();
        System.out.println("card2 = " + card2);
    }

    //#4
    public static void probarPrototype(){
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();

            PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
            amex.getCard();

        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //#5
    private static void probarSinglenton(){
        com.company.creational.singlenton.Card.getINSTANCE().setCardNumber("1234 5678 9101 1121");
        System.out.println(com.company.creational.singlenton.Card.getINSTANCE().getCardNumber());
    }

    //#6
    private static void probarChainOfResponsability(){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(100000);
    }

}