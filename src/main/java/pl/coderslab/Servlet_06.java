package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_06", urlPatterns = "/Servlet_06")
public class Servlet_06 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String number1Param = request.getParameter("number1");
        String number2Param = request.getParameter("number2");
        String number3Param = request.getParameter("number3");
        String number4Param = request.getParameter("number4");

        Double number1 = changeStringToInteger(number1Param);
        Double number2 = changeStringToInteger(number2Param);
        Double number3 = changeStringToInteger(number3Param);
        Double number4 = changeStringToInteger(number4Param);

        Double sum = number1 + number2 + number3 + number4;
        Double avg = sum/4.0;
        Double mul = number1 * number2 * number3 * number4;

        response.getWriter().append("Liczby: \n");
        response.getWriter().append("  x1: \t- ").append(number1.toString()).append("\n");
        response.getWriter().append("  x2: \t- ").append(number2.toString()).append("\n");
        response.getWriter().append("  x3: \t- ").append(number3.toString()).append("\n");
        response.getWriter().append("  x4: \t- ").append(number4.toString()).append("\n");
        response.getWriter().append("Średnia: \n");
        response.getWriter().append("      \t- ").append(avg.toString()).append("\n");
        response.getWriter().append("Suma: \n");
        response.getWriter().append("      \t- ").append(sum.toString()).append("\n");
        response.getWriter().append("Iloczyn: \n");
        response.getWriter().append("      \t- ").append(mul.toString()).append("\n");
    }

    public Double changeStringToInteger(String number) {
        Double value = 0.0;
        if (number != null && !number.equals("")) {
            value = Double.valueOf(number);
        }
        return value;
    }

}
