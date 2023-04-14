package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.WaterMappingRequestDTO;
import com.demo.waterSupply.dto.respond.WaterMappingRespondDTO;
import com.demo.waterSupply.model.WaterMeterMapping;
import com.demo.waterSupply.service.WaterMeterMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/water-mappings")
public class WaterMeterMappingController {
    @Autowired
    private WaterMeterMappingService waterMeterMappingService;
    @PostMapping
    public ResponseEntity<Object> addWaterMapping(@RequestBody WaterMappingRequestDTO waterMappingRequestDTO) {
        return new ResponseEntity<>(waterMeterMappingService.addWaterMapping(waterMappingRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getWaterMapping(@PathVariable("id") Long id){
        return new ResponseEntity<>(waterMeterMappingService.getWaterMappingById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Object> getAllWaterMapping(){
        return new ResponseEntity<>(waterMeterMappingService.getAllWaterMapping(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Object> updateWaterMapping(@RequestBody WaterMappingRespondDTO waterMappingRespondDTO){
        return new ResponseEntity<>(waterMeterMappingService.updateWaterMapping(waterMappingRespondDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWaterMappingById(@PathVariable("id") Long id){
        waterMeterMappingService.deleteWaterMappingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
