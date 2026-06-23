package com.axsos.CareSoft;

import java.util.ArrayList;

public class AdminUser implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer id;
    private int pin;
    private ArrayList<String> securityIncidents;

    public AdminUser(Integer id) {
        this.id = id;
        this.securityIncidents = new ArrayList<String>();
    }

    @Override
    public boolean assignPIN(int pin) {
        if (pin >= 100000) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (this.id.equals(confirmedAuthID)) {
            return true;
        }

        authIncident("Unauthorized access attempt with ID: " + confirmedAuthID);
        return false;
    }

    private void authIncident(String incident) {
        securityIncidents.add(incident);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }
}
