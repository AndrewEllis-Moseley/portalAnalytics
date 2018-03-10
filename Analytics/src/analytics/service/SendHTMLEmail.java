/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics.service;

/**
 *
 * @author Andrew
 */
import java.util.Date;
import java.util.Properties;
import javafx.scene.control.Label;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail {
    static Properties properties = new Properties();
    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }

    public static boolean sendEmail(String firstname, String surname, String role, String email) {
        String returnStatement = null;
        boolean emailSuccess;
        try {
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("analyticsdashboard101@gmail.com", "P0rtal102");
                }
            };
            Session session = Session.getInstance(properties, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("analyticsdashboard101@gmail.com"));            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("analyticsdashboard101@gmail.com"));
            message.setSentDate(new Date());
            message.setSubject("Analytics Dashboard Access Request");
            message.setText("The following user has requested access to use the analytics portal dashboard:\n\n"
                    + "Firstname: " + firstname
                    + "\nSurname: " + surname
                    + "\nRole: " + role
                    + "\nEmail: " + email);
            returnStatement = "Request email was sent successfully";
            
            System.out.println(returnStatement);    
            Transport.send(message); 
            emailSuccess = true;
        } catch (Exception e) {
            returnStatement = "Error sending request email";
            e.printStackTrace();
            emailSuccess = false;
        }
        return emailSuccess;
    }

    
}