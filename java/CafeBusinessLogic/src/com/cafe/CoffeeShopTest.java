package com.cafe;

public class CoffeeShopTest {
    public static void main(String[] args) {

        Product coffee = new Product("Drip Coffee", 1.50);
        Product cappuccino = new Product("Cappuccino", 3.50);
        Product latte = new Product("Latte", 4.00);
        Product muffin = new Product("Muffin", 2.25);
        Product tea = new Product("Tea", 1.75);

        CustomerOrder order1 = new CustomerOrder();
        CustomerOrder order2 = new CustomerOrder();

        CustomerOrder order3 = new CustomerOrder("Murad");
        CustomerOrder order4 = new CustomerOrder("Ramez");
        CustomerOrder order5 = new CustomerOrder("Abdullah");

        order1.addItem(coffee);
        order1.addItem(muffin);

        order2.addItem(tea);
        order2.addItem(latte);

        order3.addItem(coffee);
        order3.addItem(cappuccino);

        order4.addItem(latte);
        order4.addItem(muffin);

        order5.addItem(tea);
        order5.addItem(cappuccino);

        order1.setReady(true);
        order3.setReady(true);
        order5.setReady(true);

        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        System.out.println("-----------------------------");

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}