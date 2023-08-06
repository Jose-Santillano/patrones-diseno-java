package com.company.structural.facade;

public class Gold implements Credit{
    @Override
    public void showCredit() {
        System.out.println("Gold tiene de credito de 5,000.");
    }
}
