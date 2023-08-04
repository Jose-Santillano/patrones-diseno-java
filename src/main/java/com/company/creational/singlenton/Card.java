package com.company.creational.singlenton;

public class Card {

    //Importante
    private static Card INSTANCE;

    private String cardNumber;

    private Card(){

    }

    //Para asegurar que se crea una instancia en caso de que haya dos hilos o mas.
    public synchronized static Card getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Card();
        }
        return INSTANCE;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
