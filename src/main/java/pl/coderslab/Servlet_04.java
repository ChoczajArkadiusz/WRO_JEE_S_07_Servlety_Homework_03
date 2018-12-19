package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Servlet_04", urlPatterns = "/Servlet_04")
public class Servlet_04 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        Cookie cookie = null;
        Integer visits = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visits")) {
                    visits = Integer.valueOf(c.getValue());
                    cookie = c;
                }
            }
        }
        visits++;
        if (visits == 1) {
            response.getWriter().append("Witaj pierwszy raz na naszej stronie");
            cookie = new Cookie("visits", "1");
            cookie.setMaxAge(365 * 24 * 60 * 60);
        } else {
            response.getWriter().append("Witaj, odwiedziłeś nas już " + visits).append(" razy.");
        }
        cookie.setValue(visits.toString());
        response.addCookie(cookie);

    }


}
