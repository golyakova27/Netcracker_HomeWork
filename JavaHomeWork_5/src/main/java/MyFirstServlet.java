
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {

    private final String password = "qwerty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getParameter("password");
        String login = req.getParameter("login");

        resp.setContentType("text/html");
        resp.getWriter().write("Hello " + login + ", i save your password.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String input = req.getParameter("password");

        if (input.equals(password)) {

            String login = req.getParameter("login");

            resp.setContentType("text/html");
            resp.getWriter().write("Welcome, " + login + "!");
        }
        else {

            resp.setContentType("text/html");
            resp.getWriter().write(" is wrong password =( \nTry enter password again.");
        }
    }
}
