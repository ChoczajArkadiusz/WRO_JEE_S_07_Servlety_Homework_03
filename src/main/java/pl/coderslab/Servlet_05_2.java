package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Servlet_05_2", urlPatterns = "/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/HTML");

        String show = request.getParameter("show");

        if (show != null) {
            Map<String, CartItem> basket = (Map<String, CartItem>) request.getSession().getAttribute("basket");
            if (basket == null) {
                basket = new HashMap<>();
                request.getSession().setAttribute("basket", basket);
            }
            Set<String> items = basket.keySet();
            Double sum = 0.0;
            Double sumPartial = 0.0;

            response.getWriter().append("<table cellpadding=\"5\" >");
            for (String itemName : items) {
                CartItem item = basket.get(itemName);
                sumPartial = item.getPrice() * item.getQuantity();
                sum += sumPartial;
                response.getWriter()
                        .append("<tr>")
                        .append("<td>").append(item.getName()).append("</td>")
                        .append("<td>").append(" - ").append("</td>")
                        .append("<td align='right'>").append(item.getQuantity() + "").append("</td>")
                        .append("<td>").append(" x ").append("</td>")
                        .append("<td align='right'>").append(String.format("%.2f", item.getPrice())).append("zł").append("</td>")
                        .append("<td>").append(" = ").append("</td>")
                        .append("<td align='right'>").append(String.format("%.2f", sumPartial)).append("zł").append("</td>")
                        .append("</tr>");
            }
            response.getWriter().append("<tr>")
                    .append("<td colspan='7' align='right'>").append("SUMA: ").append(String.format("%.2f", sum)).append("zł").append("</td>")
                    .append("</tr>");
            response.getWriter().append("</table>");
        }


    }


}
