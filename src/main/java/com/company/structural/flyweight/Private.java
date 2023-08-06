package com.company.structural.flyweight;

public class Private implements Enemy{
    private String weapon;
    private final String LIFE;

    public Private(){
        LIFE = "200";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("weapon = " + weapon);
    }

    @Override
    public void lifePoints() {
        System.out.println("Vida soldado: " + LIFE);
    }
}
