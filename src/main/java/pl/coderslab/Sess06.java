package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@WebServlet(name = "Sess06", urlPatterns = "/favImages")
public class Sess06 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> choices = (Map<String, String>) request.getSession().getAttribute("choices");
        String pictureId = request.getParameter("pictureId");
        Integer picId;
        String choice = request.getParameter("choice");
        if (pictureId != null && !pictureId.equals("") &&
                choice != null && !choice.equals("")) {

            if (choices == null) {
                choices = new TreeMap<>();
            }
            choices.put(pictureId, choice);
            request.getSession().setAttribute("choices", choices);

            picId = Integer.valueOf(pictureId);
            if (picId < 8) {
                doGet(request, response);
            } else {
                response.getWriter().append("Te obrazy Ci się podobały:\n");
                Set<String> kies = choices.keySet();
                Iterator<String> iterator = kies.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (choices.get(key).equals("Y")) {
                        response.getWriter().append(key).append("\n");
                    }
                }
            }
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pagesVisited = (Integer) request.getSession().getAttribute("pagesVisited");

        if (pagesVisited == null) {
            pagesVisited = 1;
            request.getSession().setAttribute("pagesVisited", pagesVisited);
            response.sendRedirect("wybor_1.html");
        } else {
            pagesVisited += 1;
            request.getSession().setAttribute("pagesVisited", pagesVisited);
            response.sendRedirect("wybor_" + pagesVisited + ".html");
        }


    }


}
