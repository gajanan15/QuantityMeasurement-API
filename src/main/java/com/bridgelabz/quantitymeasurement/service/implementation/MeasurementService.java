package com.bridgelabz.quantitymeasurement.service.implementation;

import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService implements IQuantityMeasurementService {
    @Override
    public List<Units> getAllUnitTypes() {
        return Arrays.asList(Units.values());
    }

    @Override
    public List<SubTypes> getAllSubTypes(Units units) {
        return Arrays.stream(SubTypes.values()).filter(subTypes -> subTypes.units.equals(units))
                .collect(Collectors.toList());
    }
}
