package emailsend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Password.pass;

public class gmailSend {
    public static void main(String[] args) {
        String to = "reciever@gmail.com";  
        final String from = "sender@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("arickpaul89@gmail.com", pass.getP());
            }
        });
        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Testing Mail service");

            message.setText("Hello");

            System.out.println("Sending...");

            Transport.send(message);
            System.out.println("Sent message successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
