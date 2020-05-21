package ua.jackson.awsPractice.config;//package ua.jackson.awsPractice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${mail.debug}")
    private String debug;

//    @Value("${spring.mail.properties.mail.smtp.auth}")
//    private String auth;
//
//    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
//    private String enable;

//    @Bean
//    public JavaMailSender getMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//
//        Properties properties = mailSender.getJavaMailProperties();
//
//        properties.setProperty("mail.transport.protocol", protocol);
//        properties.setProperty("mail.debug", debug);
//
////        properties.setProperty("mail.smtp.auth", auth);
////        properties.setProperty("mail.smtp.starttls.enable", enable);
//
//        return mailSender;
//    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("testphpmailo888@gmail.com");
        mailSender.setPassword("Jackson750");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

//        props.setProperty("mail.transport.protocol", "smtp");
//        props.setProperty("mail.smtp.starttls.enable", "true");

        return mailSender;
    }

}

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.time.Instant;
//import java.util.Date;
//import java.util.Properties;
//@Component
//public class SendEmail {
//
//    @Value("${user.email.login}")
//    private String username;
//
//    @Value("${user.email.password}")
//    private String password;
//
//
//
//    public SendEmail(){
//
//    }
//
//    public SendEmail(String username, String password){
//        this.username = username;
//        this.password = password;
//    }
//
//    @Async
//    public void sendMail(String emailTo, String title, String text){
//        Properties prop = new Properties();
//        System.out.println(username);
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "465");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//        Session sessions = Session.getInstance(prop, new javax.mail.Authenticator(){
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        try {
//            Message message = new MimeMessage(sessions);
////            message.setFrom(new InternetAddress("KzzxD29@gmail.com"));
//            message.setFrom(new InternetAddress("testphpmailo888@gmail.com"));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse(emailTo)
//            );
//            message.setSubject(title);
//            message.setContent(text, "text/html;charset=utf-8");
//            message.setSentDate(Date.from(Instant.now()));
//            Transport.send(message);
//        } catch (MessagingException e){
//
//        }
//    }
//
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//}