package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reading")
public class MeterReadingController {
    @Autowired
    private MeterReadingService meterReadingService;
    @PostMapping
    public MeterReading addReading(@RequestBody MeterReading meterReading) {
        return meterReadingService.addReading(meterReading);
    }
}
