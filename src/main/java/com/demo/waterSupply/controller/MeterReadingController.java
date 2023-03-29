package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reading")
public class MeterReadingController {
    @Autowired
    private MeterReadingService meterReadingService;
    @PostMapping
    public MeterReading addReading(@RequestBody MeterReading meterReading) {
        return meterReadingService.addReading(meterReading);
    }
    @PutMapping
    public MeterReading updateMeter(@RequestBody MeterReading meterReading){
        return meterReadingService.updateMeter(meterReading);
    }
    @GetMapping("/{id}")
    public Optional<MeterReading> getMeterById(@PathVariable("id") int id){
        return meterReadingService.getMeterById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteMeterById(@PathVariable("id") int id){
         meterReadingService.deleteMeterById(id);
        return "Meter Reading deleted";
    }
}
