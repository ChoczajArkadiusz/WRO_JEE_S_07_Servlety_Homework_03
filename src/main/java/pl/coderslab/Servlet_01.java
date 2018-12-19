package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "Servlet_01", urlPatterns = "/Servlet_01")
public class Servlet_01 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String valueParam = request.getParameter("amount");
        String radioParam = request.getParameter("convType");


        Map<String, Double> conversionCoefficients = new TreeMap<>();
        if (valueParam != null && !valueParam.equals("")) {
            String[] currencies = radioParam.split("_");
            Double value = 0.0;
            conversionCoefficients.put("PLN_USD", 0.29);
            conversionCoefficients.put("USD_PLN", 3.80);
            conversionCoefficients.put("PLN_EUR", 0.25);
            conversionCoefficients.put("EUR_PLN", 4.00);
            conversionCoefficients.put("EUR_USD", 1.10);
            conversionCoefficients.put("USD_EUR", 0.92);
            value = Double.valueOf(valueParam);
            response.getWriter().append("Wartość do przelicznia: " + String.format("%.2f", value)).append(currencies[0]).append("\n");
            response.getWriter().append("Wartość po przeliczniu: " + String.format("%.2f", value * conversionCoefficients.get(radioParam)))
                    .append(currencies[1]).append("\n");


        }


    }


}
