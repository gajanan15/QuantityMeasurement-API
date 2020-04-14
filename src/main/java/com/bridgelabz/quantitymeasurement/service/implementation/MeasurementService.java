package com.bridgelabz.quantitymeasurement.service.implementation;

import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MeasurementService implements IQuantityMeasurementService {
    @Override
    public List<Units> getAllUnitTypes() {
        return Arrays.asList(Units.values());
    }
}
