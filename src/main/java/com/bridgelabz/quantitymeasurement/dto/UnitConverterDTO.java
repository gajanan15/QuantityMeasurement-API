package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;

public class UnitConverterDTO {
    public Units units;
    public SubTypes initialUnit;
    public double initialValue;
    public SubTypes outputUnit;
    public double outputValue;

    public void setOutputUnit(SubTypes outputUnit) {
        this.outputUnit = outputUnit;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public void setInitialUnit(SubTypes initialUnit) {
        this.initialUnit = initialUnit;
    }
}
