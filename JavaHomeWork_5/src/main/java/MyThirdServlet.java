import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyThirdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String text = req.getParameter("text");

        SendOnEmail sendOnEmail = new SendOnEmail(email, subject, text);
        sendOnEmail.sendLetter();

        resp.setContentType("text/html");
        resp.getWriter().write("Email Sent successfully!");
    }
}
