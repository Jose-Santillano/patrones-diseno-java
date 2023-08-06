package com.company.structural.facade;

public class Black implements Credit{
    @Override
    public void showCredit() {
        System.out.println("Black tiene de credito de 1,000,000.");
    }
}
