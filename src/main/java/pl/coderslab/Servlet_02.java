package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Servlet_02", urlPatterns = "/Servlet_02")
public class Servlet_02 extends HttpServlet {
    private static final Pattern PATERN_BOOL = Pattern.compile("[0-1]+");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String binaryNumberParam = request.getParameter("binaryNumber");

        Integer value = 0;
        Integer power = 0;
        if (isBinaryNumber(binaryNumberParam)) {
            for (int i = binaryNumberParam.length() - 1; i >= 0; i--) {
                value += (Integer.parseInt(binaryNumberParam.substring(i, i + 1))) * (int) (Math.pow(2, power++));
            }
            response.getWriter().append(binaryNumberParam).append(" to liczba ").append(value + "").append("\n");
        } else {
            response.getWriter().append("Podana wartość nie jest liczbą binarną").append("\n");
        }


    }


    public static boolean isBinaryNumber(String number) {
        Matcher matcher = PATERN_BOOL.matcher(number);
        return matcher.matches();
    }


}
