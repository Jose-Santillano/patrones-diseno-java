package com.company.creational.protitype;

public interface PrototypeCard extends Cloneable{

    void getCard();

    PrototypeCard clone() throws CloneNotSupportedException;

}
