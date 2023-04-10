package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.WaterMeterMapping;
import com.demo.waterSupply.service.WaterMeterMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaterMeterMappingController {
    @Autowired
    private WaterMeterMappingService waterMeterMappingService;
    @PostMapping("/water-mappings")
    public ResponseEntity<?> addWaterMapping(@RequestBody WaterMeterMapping mapping) {
        WaterMeterMapping addedMapping = waterMeterMappingService.addWaterMapping(mapping);
        return new ResponseEntity<>("Mapping Added", HttpStatus.CREATED);
    }
    @GetMapping("/water-mappings/{id}")
    public ResponseEntity<?> getWaterMappingById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(waterMeterMappingService.getWaterMeterMappingById(id));
    }

    @GetMapping("/water-mappings")
    public ResponseEntity<List<WaterMeterMapping>> getWaterMappings() {
        List<WaterMeterMapping> mappings =waterMeterMappingService.getWaterMappings();
        return new ResponseEntity<>(mappings, HttpStatus.OK);
    }
}
