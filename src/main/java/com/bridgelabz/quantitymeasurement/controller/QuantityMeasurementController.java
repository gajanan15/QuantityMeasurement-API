package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.respone.ResponseDTO;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService measurementService;

    @GetMapping("/unit/type")
    public ResponseEntity<List<Units>> getAllQuantityTypes() {
        return new ResponseEntity<>(measurementService.getAllUnitTypes(), HttpStatus.OK);
    }

    @GetMapping("/unit/type/{unitType}")
    public ResponseEntity<List<SubTypes>> getAllUnitByUnitTypes(@PathVariable("unitType") Units units) {
        return new ResponseEntity<>(measurementService.getAllSubTypes(units),HttpStatus.OK);
    }

    @PostMapping("/unit/convert")
    public ResponseEntity<ResponseDTO> convertUintValue(@RequestBody UnitConverterDTO unitConverterDTO){
        double convertUnit = measurementService.convertUnit(unitConverterDTO);
        ResponseDTO responseDTO = new ResponseDTO(200, "Conversion Successful", convertUnit);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
