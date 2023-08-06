package com.company.structural.flyweight;

public class Detective implements Enemy{

    private String weapon;
    private final String LIFE;

    public Detective(){
        LIFE = "1000";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("weapon = " + weapon);
    }

    @Override
    public void lifePoints() {
        System.out.println("Vida teniente: " + LIFE);
    }
}
