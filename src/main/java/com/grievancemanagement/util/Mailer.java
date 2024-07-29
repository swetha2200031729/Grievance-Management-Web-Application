package com.grievancemanagement.util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mailer {

	private String smtpHost = "smtp.gmail.com";  // Replace with your SMTP server
    private String fromEmail = "swevara@gmail.com";  // Replace with your email

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465"); // Port for SSL
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.socketFactory.port", "465");
        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, "zllg oqgt gimv nxrp");  // Replace with your SMTP username and password
            }
        });

        // Create a default MimeMessage object
        MimeMessage message = new MimeMessage(session);

        // Set From: header field
        message.setFrom(new InternetAddress(fromEmail));

        // Set To: header field
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: header field
        message.setSubject(subject);

        // Set the actual message
        message.setText(body);

        // Send the message
        Transport.send(message);
        System.out.println("Sent message successfully...");
    }
	
}
