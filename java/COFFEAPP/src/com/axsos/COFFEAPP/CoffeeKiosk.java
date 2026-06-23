package com.axsos.COFFEAPP;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {

    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    private Scanner scanner;

    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
        scanner = new Scanner(System.in);
    }

    public void addMenuItem(String name, double price) {

        Item item = new Item(name, price);

        item.setIndex(menu.size());

        menu.add(item);
    }

    public void displayMenu() {

        System.out.println("\n===== MENU =====");

        for (Item item : menu) {
            System.out.printf("%d %s -- $%.2f%n",
                    item.getIndex(),
                    item.getName(),
                    item.getPrice());
        }
    }

    public void newOrder() {

        System.out.println("\nPlease enter customer name for new order:");

        String customerName = scanner.nextLine();

        Order order = new Order(customerName);

        displayMenu();

        System.out.println("\nPlease enter a menu item index or q to quit:");

        String itemNumber = scanner.nextLine();

        while (!itemNumber.equalsIgnoreCase("q")) {

            try {

                int index = Integer.parseInt(itemNumber);

                if (index >= 0 && index < menu.size()) {

                    Item item = menu.get(index);

                    order.addItem(item);

                    System.out.println(
                            item.getName() + " added to order."
                    );

                } else {

                    System.out.println("Invalid menu item index.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }

            System.out.println(
                    "Please enter another menu item index or q to quit:"
            );

            itemNumber = scanner.nextLine();
        }

        orders.add(order);

        System.out.println("\n===== ORDER SUMMARY =====");

        order.display();
    }

    // Ninja Bonus

    public void addMenuItemByInput() {

        System.out.println("Enter item name:");

        String name = scanner.nextLine();

        System.out.println("Enter item price:");

        double price = Double.parseDouble(scanner.nextLine());

        addMenuItem(name, price);

        System.out.println("Item added successfully.");
    }
}