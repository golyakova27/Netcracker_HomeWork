import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class MySecondServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String browserName = req.getHeader("User-Agent");

        ServletOutputStream out = resp.getOutputStream();

        out.println("<html>");
        out.println("<head></head>");

        out.println("<body>");
        out.println("<h1>Inform for you</h1>");
        out.println("<p>Date: " + new Date() + "</p>");
        out.println("<p>Browser: " + browserName + "</p>");
        out.println("</body>");
        out.println("<html>");
    }
}
