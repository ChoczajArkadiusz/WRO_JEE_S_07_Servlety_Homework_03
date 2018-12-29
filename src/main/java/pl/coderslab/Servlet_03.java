package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet_03", urlPatterns = "/Servlet_03")
public class Servlet_03 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String field1 = request.getParameter("field1");
        String field2 = request.getParameter("field2");
        String field3 = request.getParameter("field3");
        String field4 = request.getParameter("field4");
        String field5 = request.getParameter("field5");

        HttpSession session = request.getSession();
        session.setAttribute("field1", field1);
        session.setAttribute("field2", field2);
        session.setAttribute("field3", field3);
        session.setAttribute("field4", field4);
        session.setAttribute("field5", field5);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String field1 = (String) session.getAttribute("field1");
        String field2 = (String) session.getAttribute("field2");
        String field3 = (String) session.getAttribute("field3");
        String field4 = (String) session.getAttribute("field4");
        String field5 = (String) session.getAttribute("field5");

        if (field1 == null) { field1 = "";}
        if (field2 == null) { field2 = "";}
        if (field3 == null) { field3 = "";}
        if (field4 == null) { field4 = "";}
        if (field5 == null) { field5 = "";}

        response.getWriter().append("<form action='/Servlet_03' method='post'>")
               .append("<label>pole 1:<input type='text' name='field1' value='").append(field1).append("'></label><br>")
               .append("<label>pole 2:<input type='text' name='field2' value='").append(field2).append("'></label><br>")
               .append("<label>pole 3:<input type='text' name='field3' value='").append(field3).append("'></label><br>")
               .append("<label>pole 4:<input type='text' name='field4' value='").append(field4).append("'></label><br>")
               .append("<label>pole 5:<input type='text' name='field5' value='").append(field5).append("'></label><br>")
               .append("<br><br>")
               .append("<input type='submit' name='userSubmit' value='Zatwierdź'>")
               .append("</form>");
    }


}
