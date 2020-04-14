package com.bridgelabz.quantitymeasurement;

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

}
