package com.company.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void dettach(Observer o) {
        observers.remove(0);
    }

    @Override
    public void nofityUpdate(Semaforo semaforo) {
        for(Observer o: observers){
            o.update(semaforo);
        }
    }
}
