package com.demo.waterSupply.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }
    public void sendMail(String to,String subject,String text){
        emailService.sendEmail(to,subject,text );
    }
}
