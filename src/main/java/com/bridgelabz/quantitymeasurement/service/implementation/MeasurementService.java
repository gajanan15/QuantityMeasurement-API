package com.bridgelabz.quantitymeasurement.service.implementation;

import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.bridgelabz.quantitymeasurement.enumeration.SubTypes.CELSIUS;
import static com.bridgelabz.quantitymeasurement.enumeration.SubTypes.FAHRENHEIT;

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

    @Override
    public double convertUnit(UnitConverterDTO unitConverterDTO) {
        double outPutValue;
            if (unitConverterDTO.initialUnit.equals(CELSIUS) && unitConverterDTO.outputUnit.equals(FAHRENHEIT)) {
                outPutValue = ((unitConverterDTO.initialValue * unitConverterDTO.initialUnit.conversionUnit) + 32);
            } else if (unitConverterDTO.initialUnit.equals(FAHRENHEIT) && unitConverterDTO.outputUnit.equals(CELSIUS)) {
                outPutValue = ((unitConverterDTO.initialValue - 32) * unitConverterDTO.initialUnit.conversionUnit);
            } else {
                outPutValue = (unitConverterDTO.initialValue * unitConverterDTO.initialUnit.conversionUnit) / unitConverterDTO.outputUnit.conversionUnit;
            }
            return outPutValue;
        }
}
