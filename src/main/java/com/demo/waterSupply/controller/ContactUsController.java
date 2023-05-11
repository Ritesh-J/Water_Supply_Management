package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.ContactUsDTO;
import com.demo.waterSupply.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact-us")
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;
    @PostMapping
    public ResponseEntity<Object> contactUs(@RequestBody ContactUsDTO contactUsDTO){
        contactUsService.sendContactUs(contactUsDTO);
        return new ResponseEntity<>("Information Sent", HttpStatus.OK);

    }

}
