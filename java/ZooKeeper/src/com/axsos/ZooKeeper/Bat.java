package com.axsos.ZooKeeper;

public class Bat extends Mammal {

    public Bat() {
        this.energy = 300;
    }

    public void fly() {
        energy -= 50;
        System.out.println("The bat is now airborne.");
    }

    public void eatHumans() {
        energy += 25;
        System.out.println("The bat is satisfied after eating a human.");
    }

    public void attackTown() {
        energy -= 100;
        System.out.println("The bat attacked a town.");
    }
}
