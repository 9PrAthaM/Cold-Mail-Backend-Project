package com.example.ColdEmail.EmailSender.Controller;

import com.example.ColdEmail.EmailSender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class SendEmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/sendmailwithattachment")
    public ResponseEntity sendEmailsWithAttachment(@RequestBody Map<String, List> requestBody) throws Exception {
        emailService.sendMailWithAttachment(requestBody.get("emails"),"test mail",
                "hii ");
        return new ResponseEntity("emails has been send succesfully",HttpStatus.OK);
    }
}
