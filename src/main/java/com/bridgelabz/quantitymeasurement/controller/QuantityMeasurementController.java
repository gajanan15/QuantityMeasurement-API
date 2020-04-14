package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService measurementService;

    @GetMapping("/unit/type")
    public List<Units> getAllQuantityTypes() {
        return measurementService.getAllUnitTypes();
    }

    @GetMapping("/unit/type/{unitType}")
    public List<SubTypes> getAllUnitByUnitTypes(@PathVariable("unitType") Units units) {
        return measurementService.getAllSubTypes(units);
    }

    @PostMapping("/unit/convert")
    public UnitConverterDTO convertUintValue(@RequestBody UnitConverterDTO unitConverterDTO){
        return measurementService.concertUnit(unitConverterDTO);
    }
}
