package com.example.ColdEmail.EmailSender.ServiceImpl;

import com.example.ColdEmail.EmailSender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendMailWithAttachment(List<String> emailAddress, String subject, String body
    ) throws Exception {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            if (!emailAddress.isEmpty()) {
                helper.setTo(emailAddress.get(0));
                helper.setSubject(subject);
                helper.setText(body);
                helper.addAttachment("Resume.pdf",new File("C:/Users/91866/Downloads/Pratham's Updated cv"));
                mailSender.send(message);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
