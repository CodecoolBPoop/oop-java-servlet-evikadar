package com.codecool.servlet;

public class Item {
    private static int id = 1;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        id = id;
        id++;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": " + price + " HUF";
    }
}
