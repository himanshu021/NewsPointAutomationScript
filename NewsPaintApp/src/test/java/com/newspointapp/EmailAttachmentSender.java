package com.newspointapp;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class EmailAttachmentSender {
	 
    public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        Address[] toAddresses = new Address[] {
                new InternetAddress("Amit.Monga@timesinternet.in"),
                new InternetAddress("aditya.chaturvedi@timesinternet.in"),
                new InternetAddress("deepank.rastogi@timesinternet.in"),
                new InternetAddress("Shiva.Shukla@timesinternet.in"),
                new InternetAddress("rajanikant.himanshu@timesinternet.in"),
                new InternetAddress("Abhishek.Nigam1@timesinternet.in"),
                new InternetAddress("shivika.sharma@timesinternet.in"),
                new InternetAddress("rahul.khanduri@timesinternet.in"),
                new InternetAddress("harsh.upadhyay@timesinternet.in"),
                new InternetAddress("harpreet.singh6@timesinternet.in"),
                new InternetAddress("ranjeet.paliwal@kelltontech.com"),
                new InternetAddress("Sidharth.Jain@timesinternet.in"),
                new InternetAddress("fanendra.tripathi@timesinternet.in"),
                 };
//        Address[] toAddresses = new Address[] {
//                new InternetAddress("Amit.Monga@timesinternet.in"),
//                new InternetAddress("rajanikant.himanshu@timesinternet.in")};

        
        //InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
 
    /**
     * Test sending e-mail with attachments
     */
   // public static void main(String[] args) 
    @Test(enabled = true)
     public void sentEmail() {
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "times.automationtest@gmail.com";
        String password = "Times@123";
 
        // message info
        String mailTo;
        mailTo= "rajanikant.himanshu@gmail.com"; //amitm1979@gmail.com
        //mailTo = "rajanikant.himanshu@timesinternet.in"; 
        String subject = "Content freshness report for NP Android - Across Pub";
        String message = " Hello, " + 
        		"\n Attached is the content freshness report for NP Android app's Across Publication. " +
        		"\n Thanks, \n QC Team";
 
        // attachments
        String[] attachFiles = new String[1];
        attachFiles[0] = "C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt";
//        attachFiles[1] = "e:/Test/Music.mp3";
//        attachFiles[2] = "e:/Test/Video.mp4";
 
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
}