package com.codecool.servlet;

import java.util.ArrayList;

public class ItemStore {
    private ArrayList<Item> items;

    public ItemStore() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> add(Item item) {
        items.add(item);
        return items;
    }

    public ArrayList<Item> remove(Item item) {
        try {
            items.remove(item);

        } catch (NullPointerException e) {
            System.out.printf("Cant find this item :( %n");
        }
        return items;
    }

    public int getSize() {
        return items.size();
    }


    public String getItemPriceByIdx(int index) {
        Item item = items.get(index);
        return String.valueOf(item.getPrice());
    }

    public String getItemNameByIdx (int index) {
        Item item = items.get(index);
        return item.getName();
    }

    public void addToCart(int index) {
        int price = Integer.parseInt(getItemPriceByIdx(index));
        Item addToCart = new Item(getItemNameByIdx(index), price);
        items.add(addToCart);
        System.out.printf("%s%n added to cart", addToCart.toString());
    }

    public Item getItem(int nr) {
        Item item = items.get(nr);
        return item;
    }

    public void removeFromCart(int index) {
        Item toRemove = items.get(index);
        items.remove(toRemove);
        System.out.printf("%s%n removed from cart", toRemove.toString());
    }
}
