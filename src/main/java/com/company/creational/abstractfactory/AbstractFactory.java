package com.company.creational.abstractfactory;

//Nos permite crear varias factorias de métodos en concreto.
public interface AbstractFactory<T>{

    T create(String type);
}
