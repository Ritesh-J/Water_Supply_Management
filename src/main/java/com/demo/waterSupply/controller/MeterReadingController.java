package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.MeterReadingRequestDTO;
import com.demo.waterSupply.service.NotificationService;
import com.demo.waterSupply.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reading")
public class MeterReadingController {
    @Autowired
    private MeterReadingService meterReadingService;
    @Autowired
    private NotificationService notificationService;
//    @GetMapping("/email")
//    public ResponseEntity<Object> emailGet(){
//        demoService.sendMail();
//        return new ResponseEntity<>("Check Email",HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Object> addMeterReading(@RequestBody MeterReadingRequestDTO meterReadingRequestDTO){
        return new ResponseEntity<>(meterReadingService.addReading(meterReadingRequestDTO), HttpStatus.CREATED);
    }
    @PostMapping("/all-reading")
    public ResponseEntity<Object> addAllReading(@RequestBody List<MeterReadingRequestDTO> meterReadingRequestDTOList){
        return new ResponseEntity<>(meterReadingService.addAllReading(meterReadingRequestDTOList),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReadingById(@PathVariable("id") Long id){
        return new ResponseEntity<>(meterReadingService.getReadingById(id),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Object> getAllReadings(){
        return new ResponseEntity<>(meterReadingService.getAllReading(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMeterReadingById(@PathVariable("id") Long id){
        meterReadingService.deleteMeterReadingById(id);
        return new ResponseEntity<>("Reading Deleted",HttpStatus.OK);
    }
}
