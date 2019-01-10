package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cartServlet", urlPatterns = {"/cart"}, loadOnStartup = 3)
public class ShoppingCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemStore allProducts = WebshopServlet.getAllProducts();
        ItemStore cart = WebshopServlet.getCart();

        if (req.getParameter("addProductNr") != null) {
            int prodToAdd = Integer.parseInt(req.getParameter("addProductNr"));
            Item toAdd = allProducts.getItem(prodToAdd);
            cart.add(toAdd);

        } else if (req.getParameter("removeProductNr") != null) {
            int prodNr = Integer.parseInt(req.getParameter("removeProductNr"));
            cart.removeFromCart(prodNr);
        }

        PrintWriter out = resp.getWriter();
        String title = "I am doing a test for the cart!";
        String intro = "Your Cart";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1>" + intro + "</h1>" +
                        "<table>\n"
        );

        for (int i = 0; i < cart.getSize(); i++) {
            out.println(
                    "<tr\n>" +
                            "<td>" + cart.getItemNameByIdx(i) + "</td>" +
                            "<td>" + cart.getItemPriceByIdx(i) + " HUF </td>" +
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
        );    }
}
