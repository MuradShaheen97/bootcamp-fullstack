package com.cafe;

import java.util.ArrayList;

public class CustomerOrder {
    private String name;
    private boolean ready;
    private ArrayList<Product> products;

    public CustomerOrder() {
        this.name = "Guest";
        this.ready = false;
        this.products = new ArrayList<Product>();
    }

    public CustomerOrder(String name) {
        this.name = name;
        this.ready = false;
        this.products = new ArrayList<Product>();
    }

    public void addItem(Product product) {
        this.products.add(product);
    }

    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double total = 0;

        for (Product product : this.products) {
            total += product.getPrice();
        }

        return total;
    }

    public void display() {
        System.out.println("Customer Name: " + this.name);

        for (Product product : this.products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        System.out.println("Total: $" + this.getOrderTotal());
        System.out.println("-----------------------------");
    }

    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}