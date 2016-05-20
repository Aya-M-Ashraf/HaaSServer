package com.haas.server.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Hossam
 */
public class PasswordSenderMail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void generateAndSendEmail(String password, String email) {

        try {
            // Step1 ---> setup Mail Server Properties
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            // Step2 ---> get Mail Session
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
            generateMailMessage.setSubject("The Updated Password !!");
            String emailBody = "Your new password is: " + "<br><br>"+password+"<br><br>Ragards <br> HaaS Admin";
            generateMailMessage.setContent(emailBody, "text/html");

            // Step3 ---> Get Session and Send mail
            Transport transport = getMailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", "haasApp.999@gmail.com", "haasProject");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            Logger.getLogger(PasswordSenderMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
