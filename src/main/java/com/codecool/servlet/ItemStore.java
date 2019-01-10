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


    public double getItemPriceByIdx(int index) {
        Item item = items.get(index);
        return item.getPrice();
    }

    public String getItemNameByIdx (int index) {
        Item item = items.get(index);
        return item.getName();
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

    @Override
    public String toString() {
        StringBuilder cartContent = new StringBuilder();
        for (Item item: items) {
            String written = item.toString();
            cartContent.append(written);
            cartContent.append("\n");
        }
        return String.valueOf(cartContent);
    }
}
