package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService measurementService;

    @GetMapping("/unit/type")
    public List<Units> getAllQuantityTypes() {
        return measurementService.getAllUnitTypes();
    }
}