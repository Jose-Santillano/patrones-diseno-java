package com.company.structural.facade;

public class Silver implements Credit{
    @Override
    public void showCredit() {
        System.out.println("Silver tiene de credito de 200,000.");
    }
}
