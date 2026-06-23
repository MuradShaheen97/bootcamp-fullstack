package com.axsos.COFFEAPP;

import java.util.ArrayList;

public class Order {

    private String name;
    private ArrayList<Item> items;
    private boolean ready;

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getOrderTotal() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        }
        return "Thank you for waiting. Your order will be ready soon.";
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void display() {
        System.out.println("\nCustomer Name: " + name);

        for (Item item : items) {
            System.out.printf("%s -- $%.2f%n",
                    item.getName(),
                    item.getPrice());
        }

        System.out.printf("Total: $%.2f%n", getOrderTotal());
    }
}
