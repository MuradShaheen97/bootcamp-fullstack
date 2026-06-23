package com.axsos.DeviceProject;

public class Phone extends Device {

    public void makeCall() {
        battery -= 5;
        System.out.println("You make a call.");
        status();
        batteryCritical();
    }

    public void playGame() {
        if (battery < 25) {
            System.out.println("Battery too low to play a game.");
            status();
            return;
        }

        battery -= 20;
        System.out.println("You play a game.");
        status();
        batteryCritical();
    }

    public void charge() {
        battery += 50;

        if (battery > 100) {
            battery = 100;
        }

        System.out.println("You charge the phone.");
        status();
    }

    private void batteryCritical() {
        if (battery < 10) {
            System.out.println("Battery critical!");
        }
    }
}