package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.repository.MeterRepository;
import com.demo.waterSupply.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private MeterReadingService meterReading;
    @Autowired
    private MeterRepository meterRepository;
    @GetMapping
    public ResponseEntity<Object> demoFun(){
        MeterModel meterModel=meterRepository.findById(1L).get();
        return new ResponseEntity<>(meterReading.getUserEmails(meterModel), HttpStatus.OK);
    }

}
