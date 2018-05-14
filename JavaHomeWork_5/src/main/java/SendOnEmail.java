
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendOnEmail {

    private static final String emailFrom = "user@yandex.ru";
    private static final String username = "user";
    private static final String password = "user";
    private String emailTo;
    private String subject;
    private String text;

    public SendOnEmail(String emailTo, String subject, String text) {

        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public void sendLetter() {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        }
        catch (MessagingException mex) {

            mex.printStackTrace();
        }
    }
}
