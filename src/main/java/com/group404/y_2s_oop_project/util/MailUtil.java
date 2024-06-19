/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group404.y_2s_oop_project.util;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
public class MailUtil {

    private static final String SMTP_HOST = "smtp.zoho.com";
    private static final String SMTP_PORT = "587";
    private static final String SMTP_AUTH = "true";
    private static final String SMTP_STARTTLS = "true";

    private static final String USERNAME = "admin@shipsharp.xyz"; 
    private static final String PASSWORD = "Ganidubro5@"; 

    private static Session session;

    static {
        Properties props = new Properties();
        props.put("mail.smtp.auth", SMTP_AUTH);
        props.put("mail.smtp.starttls.enable", SMTP_STARTTLS);
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
    }

    public static void sendOrderPlacedMail(String toEmail, String subject, String product, String price) {
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            String msgContent = "Your order has been placed successfully!\n\n"
                    + "Product: " + product + "\n"
                    + "Price: " + price + "\n\n"
                    + "Thank you for shopping with us.";

            message.setText(msgContent);

            Transport.send(message);

            System.out.println("Email sent successfully to " + toEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

   
}
