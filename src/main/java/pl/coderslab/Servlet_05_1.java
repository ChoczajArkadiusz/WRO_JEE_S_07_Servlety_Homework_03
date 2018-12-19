package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Servlet_05_1", urlPatterns = "/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String name = request.getParameter("name");
        String quantityParam = request.getParameter("quantity");
        String priceParam = request.getParameter("price");

        Integer quantity = Integer.valueOf(quantityParam);
        Double price = Double.valueOf(priceParam);
        CartItem cartItem = new CartItem(name, quantity, price);

        Map<String, CartItem> basket = (Map<String, CartItem>) request.getSession().getAttribute("basket");
        if (basket == null) {
            basket = new HashMap<>();
            request.getSession().setAttribute("basket", basket);
        }
        basket.put(name, cartItem);

        response.sendRedirect("/Servlet_05_1?productAdded=true");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String productAdded = request.getParameter("productAdded");
        if( productAdded != null && productAdded.equals("true")) {
            response.getWriter()
                .append("Dodano produkt do koszyka.<br><br>")
                .append("Możesz dodać kolejny produkt: <br><br>");
        }

        response.getWriter()
                .append("<form method='post' action='/Servlet_05_1' accept-charset='utf-8'>")
                .append("<label>Nazwa: <input type='text' name='name' placeholder='Podaj nazwę' /></label><br>")
                .append("<label>Ilość: <input type='number' min='0' step='1'  name='quantity' placeholder='Podaj ilość' /></label><br>")
                .append("<label>Cena: <input type='number' min='0.00' step='0.01'  name='price' placeholder='Podaj cenę' /></label><br><br>")
                .append("<input type='submit' name='submit' value='Zatwierdź' />")
                .append("</form>")
                .append("<br><br><br>")
                .append("<a href='/Servlet_05_2?show=true'> Koszyk </a>");


    }


}
