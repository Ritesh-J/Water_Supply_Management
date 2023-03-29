package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/meter")
public class MeterController {
    @Autowired
    private MeterService meterService;
    @PostMapping
    public MeterModel addMeter(@RequestBody MeterModel meterModel) {
        return meterService.addMeter(meterModel);
    }
    @GetMapping("/{id}")
    public Optional<MeterModel> getMeterById(@PathVariable("id") int id) {
        return meterService.getMeterById(id);
    }
    @PutMapping
    public MeterModel updateMeter(@RequestBody MeterModel meterModel) {
        return meterService.updateMeter(meterModel);
    }
    @DeleteMapping("/{id}")
    public String deleteMeterById(@PathVariable("id") int id) {
         meterService.deleteById(id);
        return "Meter Deleted";
    }

}
