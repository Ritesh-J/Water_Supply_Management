//package com.demo.waterSupply.controller;
//
//import com.demo.waterSupply.model.MeterReading;
//import com.demo.waterSupply.service.MeterReadingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/reading")
//public class MeterReadingController {
//    @Autowired
//    private MeterReadingService meterReadingService;
//    @PostMapping
//    public MeterReading addReading(@RequestBody MeterReading meterReading) {
//        return meterReadingService.addReading(meterReading);
//    }
//    @PostMapping("/all-reading")
//    public List<MeterReading> addAllReading(@RequestBody List<MeterReading> meterReadings){
//        return meterReadingService.addAllReading(meterReadings);
//    }
//    @PutMapping
//    public MeterReading updateMeter(@RequestBody MeterReading meterReading){
//        return meterReadingService.updateMeter(meterReading);
//    }
//    @GetMapping("/{id}")
//    public Optional<MeterReading> getMeterReadingById(@PathVariable("id") Long id){
//        return meterReadingService.getMeterById(id);
//    }
//    @GetMapping("/all-reading")
//    public List<MeterReading> getAllReading(){
//        return meterReadingService.getAllReading();
//    }
//    @DeleteMapping("/{id}")
//    public String deleteMeterById(@PathVariable("id") Long id){
//         meterReadingService.deleteMeterById(id);
//        return "Meter Reading deleted";
//    }
//}
