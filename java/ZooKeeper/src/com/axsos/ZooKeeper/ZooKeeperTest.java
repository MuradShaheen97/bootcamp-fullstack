package com.axsos.ZooKeeper;

public class ZooKeeperTest {
    public static void main(String[] args) {

        System.out.println("===== Gorilla Test =====");

        Gorilla gorilla = new Gorilla();

        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();

        gorilla.eatBananas();
        gorilla.eatBananas();

        gorilla.climb();

        gorilla.displayEnergy();

        System.out.println("\n===== Bat Test =====");

        Bat bat = new Bat();

        bat.attackTown();
        bat.attackTown();
        bat.attackTown();

        bat.eatHumans();
        bat.eatHumans();

        bat.fly();
        bat.fly();

        bat.displayEnergy();
    }
}
