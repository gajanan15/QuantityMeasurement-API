package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;

import java.util.List;

public interface IQuantityMeasurementService {

    List<Units> getAllUnitTypes();

    List<SubTypes> getAllSubTypes(Units units);

    double convertUnit(UnitConverterDTO unitConverterDTO);
}
