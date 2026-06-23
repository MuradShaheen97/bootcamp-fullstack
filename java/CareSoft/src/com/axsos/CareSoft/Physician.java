package com.axsos.CareSoft;

public class Physician implements HIPAACompliantUser {
    private Integer id;
    private int pin;

    public Physician(Integer id) {
        this.id = id;
    }

    @Override
    public boolean assignPIN(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return this.id.equals(confirmedAuthID);
    }
}
