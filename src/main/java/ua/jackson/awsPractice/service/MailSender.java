package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender  {

    @Qualifier("getMailSender")
    @Autowired
    private JavaMailSender send;

    @Value("${spring.mail.username}")
    private String username;


//    public void send(String emailTo, String subject, String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//        mailMessage.setFrom(username);
//        mailMessage.setTo(emailTo);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//
//        mailSender.send(mailMessage);
//    }


    public void sendSimpleMessage() {

        String to = "taras.galyuk.98@gmail.com";
        String subject = "Hello";
        String text = "Hello from mail";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        send.send(message);
    }


}