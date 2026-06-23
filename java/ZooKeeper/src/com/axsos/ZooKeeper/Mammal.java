package com.axsos.ZooKeeper;

public class Mammal {
    protected int energy;

    public Mammal() {
        this.energy = 100;
    }

    public int displayEnergy() {
        System.out.println("Energy Level: " + energy);
        return energy;
    }
}