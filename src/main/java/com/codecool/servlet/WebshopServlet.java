package com.codecool.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "webshopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 3)
public class WebshopServlet extends HttpServlet {
    public static ItemStore itemStore = new ItemStore();
    public static ItemStore cart = new ItemStore();


    @Override
    public void init() throws ServletException {
        itemStore.add(new Item("Theatre Today", 2800));
        itemStore.add(new Item("Bunker Walk in Csepel", 5400));
        itemStore.add(new Item("DIY Cooking Restaurant", 6000));
        itemStore.add(new Item("Open Air Concert", 2300));
        itemStore.add(new Item("Escape Room", 2400));
        itemStore.add(new Item("Dance Workshop", 7500));
    }

    public static ItemStore getAllProducts() {
        return itemStore;
    }

    public static ItemStore getCart() {
        return cart;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String title = "I am doing a test!";
        String intro = "Pick the best gift ideas";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1>" + intro + "</h1>" +
                        "<table>\n"
        );

        for (int i = 0; i < itemStore.getSize(); i++) {
            out.println(
                    "<tr\n>" +
                            "<td>" + itemStore.getItemNameByIdx(i) + "</td>" +
                            "<td>" + itemStore.getItemPriceByIdx(i) + " HUF </td>" +
                            "<td>" +
                            "<form action='cart' method='get'>" +
                            "<button type='submit' name='addProductNr' value= " + i + ">Add</button>" +
                            "</td>" +
                            "<td>" +
                            "<button type='submit' name='removeProductNr' value= " + i + ">Remove</button>" +
                            "</form>" +
                            "</td>" +
                            "</tr\n>"
            );
        }

        out.println(
                "<div>" +
                    "<form action = '/cart'>" +
                        "<button type='submit'>Check Shopping Cart</button>" +
                    "</form>" +
                "</div>"
        );


    }


}

