package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meter")
public class MeterController {
    @Autowired
    private MeterService meterService;
    @PostMapping
    public MeterModel addMeter(@RequestBody MeterModel meterModel) {
        return meterService.addMeter(meterModel);
    }
}
