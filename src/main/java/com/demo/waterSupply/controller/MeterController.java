package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.MeterRequestDTO;
import com.demo.waterSupply.dto.respond.MeterRespondDTO;
import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/meter")
public class MeterController {
    @Autowired
    private MeterService meterService;
    @PostMapping
    public ResponseEntity<Object> addMeter(@RequestBody MeterRequestDTO meterRequestDTO) {
        return new ResponseEntity<>(meterService.addMeter(meterRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getMeterById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(meterService.getMeterById(id),HttpStatus.FOUND);
    }
    @GetMapping("/all-meter")
    public ResponseEntity<Object> getAllMeter(){
        return new ResponseEntity<>(meterService.getAllMeter(),HttpStatus.OK);
    }
    @PutMapping
    public MeterModel updateMeter(@RequestBody MeterRespondDTO meterRespondDTO) {
        return meterService.updateMeter(meterRespondDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMeterById(@PathVariable("id") Long id) {
         meterService.deleteById(id);
        return new ResponseEntity<>("Meter Deleted", HttpStatus.OK);
    }

}
