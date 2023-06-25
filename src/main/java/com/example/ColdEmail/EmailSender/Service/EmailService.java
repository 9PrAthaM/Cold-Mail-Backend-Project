package com.example.ColdEmail.EmailSender.Service;

import java.util.List;

public interface EmailService {
    public void sendMailWithAttachment(List<String> emailAddress, String subject, String body) throws Exception;
}
