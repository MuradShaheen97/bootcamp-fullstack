package com.axsos.CareSoft;

public class CareSoftTest {
    public static void main(String[] args) {

        Physician doctor = new Physician(1);

        System.out.println(doctor.assignPIN(1234)); // true
        System.out.println(doctor.assignPIN(12345)); // false
        System.out.println(doctor.accessAuthorized(1)); // true
        System.out.println(doctor.accessAuthorized(2)); // false

        System.out.println("----------------------");

        AdminUser admin = new AdminUser(99);

        System.out.println(admin.assignPIN(123456)); // true
        System.out.println(admin.assignPIN(1234)); // false
        System.out.println(admin.accessAuthorized(99)); // true
        System.out.println(admin.accessAuthorized(100)); // false

        System.out.println(admin.reportSecurityIncidents());
    }
}