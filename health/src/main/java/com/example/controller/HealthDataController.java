package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.HealthData;
import com.example.service.HealthDataService;


@RestController
@RequestMapping("/api/health-data")
@CrossOrigin(origins="http://localhost:5500")
public class HealthDataController {
	
	@Autowired
    private  HealthDataService healthDataService;

    public HealthDataController(HealthDataService healthDataService) {
        this.healthDataService = healthDataService;
    }

    @PostMapping("/saveHealthData/{healthData}")
    public ResponseEntity<HealthData> saveHealthData(@RequestBody HealthData healthData) {
        return new  ResponseEntity<HealthData>( healthDataService.saveHealthData(healthData),HttpStatus.OK);
    }

    @GetMapping("/getHealthDataByUserId/{userId}")
    public ResponseEntity<List<HealthData>> getHealthDataByUserId(@PathVariable Long userId) {
        return new ResponseEntity<List<HealthData>>(healthDataService.getHealthDataByUserId(userId),HttpStatus.OK);
    }
}