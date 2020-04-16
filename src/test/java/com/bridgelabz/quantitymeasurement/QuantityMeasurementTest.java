package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.implementation.MeasurementService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuantityMeasurementTest {

    @Test
    void givenQuantityMeasurement_ShouldReturnAllUnitList() {
        MeasurementService measurementService = new MeasurementService();
        List<Units> allQuantityTypes = measurementService.getAllUnitTypes();
        Assert.assertEquals(4,allQuantityTypes.size());
    }

    @Test
    void givenQuantityMeasurement_ShouldReturnAllSubUnits() {
        MeasurementService measurementService = new MeasurementService();
        List<SubTypes> allSubTypes = measurementService.getAllSubTypes(Units.LENGTH);
        Assert.assertEquals(4,allSubTypes.size());
    }

    @Test
    void givenQuantityMeasurementInVolume_When1FeetConvertToInch_ShouldReturn12Inch() {
        MeasurementService measurementService = new MeasurementService();
        UnitConverterDTO unitConverterDTO = new UnitConverterDTO();
        unitConverterDTO.setInitialUnit(SubTypes.FEET);
        unitConverterDTO.setOutputUnit(SubTypes.INCH);
        unitConverterDTO.setInitialValue(1.0);
        double convertedResult = measurementService.convertUnit(unitConverterDTO);
        Assert.assertEquals(12.0,convertedResult,0.0);
    }

    @Test
    void givenQuantityMeasurementInTemperature_When0CelsiusConvertToFahrenheit_ShouldReturn32Fahrenheit() {
        MeasurementService measurementService = new MeasurementService();
        UnitConverterDTO unitConverterDTO = new UnitConverterDTO();
        unitConverterDTO.setInitialUnit(SubTypes.CELSIUS);
        unitConverterDTO.setOutputUnit(SubTypes.FAHRENHEIT);
        unitConverterDTO.setInitialValue(0.0);
        double convertedResult = measurementService.convertUnit(unitConverterDTO);
        Assert.assertEquals(32.0,convertedResult,0.0);
    }
}
