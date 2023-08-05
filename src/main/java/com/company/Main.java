package com.company;

import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDesactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.behavioral.iterator.CardList;
import com.company.behavioral.iterator.Iterator;
import com.company.behavioral.iterator.List;
import com.company.behavioral.mediator.ConcreteColleage1;
import com.company.behavioral.mediator.ConcreteColleage2;
import com.company.behavioral.mediator.ConcreteMediator;
import com.company.behavioral.memento.Article;
import com.company.behavioral.memento.ArticleMemento;
import com.company.behavioral.memento.Carataker;
import com.company.behavioral.observer.Coche;
import com.company.behavioral.observer.MessagePublisher;
import com.company.behavioral.observer.Peaton;
import com.company.behavioral.observer.Semaforo;
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
        //probarChainOfResponsability();
        //#7
        //probarCommand();
        //#8
        //probarIterator();
        //#9
        //probarMediator();
        //#10
        //probarMemento();
        //#11
        probarObserver();

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

    //#7
    private static void probarCommand(){
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDesactivate = new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();
        invoker.setCommand(new CreditCardActivateCommand((creditCard)));
        invoker.run();
        System.out.println("---");

        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivate));
        invoker.run();
    }

    //#8
    private static void probarIterator(){
        com.company.behavioral.iterator.Card[] cards = new com.company.behavioral.iterator.Card[5];
        cards[0] = new com.company.behavioral.iterator.Card("VISA");
        cards[1] = new com.company.behavioral.iterator.Card("AMEX");
        cards[2] = new com.company.behavioral.iterator.Card("MASTERCARD");
        cards[3] = new com.company.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new com.company.behavioral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);

        Iterator iterator = lista.iterator();

        while(iterator.hasNext()){
            com.company.behavioral.iterator.Card tarjeta = (com.company.behavioral.iterator.Card) iterator.next();
            System.out.println(tarjeta.getType());
        }

    }

    //#9
    private static void probarMediator(){
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1.");
        user2.send("Hola user1, soy user2.");
    }

    //#10
    private static void probarMemento(){
        Carataker carataker = new Carataker();
        Article article = new Article("Alberto", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");

        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());
        article.setText(article.getText() + " protagonizada por Guy Parce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        System.out.println("memento1 = " + memento1);
        System.out.println("memento2 = " + memento2);

        article.restoreMemento(memento1);
        System.out.println(article.getText());

        article.restoreMemento(memento2);
        System.out.println(article.getText());

    }

    //#11
    private static void probarObserver(){
        Coche coche = new Coche();
        Peaton peaton = new Peaton();
        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);

        messagePublisher.nofityUpdate(new Semaforo("ROJO_COCHE"));

        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        messagePublisher.nofityUpdate(new Semaforo("VERDE_COCHE"));

    }
}