package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;

public class UnitConverterDTO {
    public double initialValue;
    public SubTypes initialUnit;
    public Units units;
    public double outputValue;
    public SubTypes outputUnit;

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public SubTypes getInitialUnit() {
        return initialUnit;
    }

    public Units getUnits() {
        return units;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public SubTypes getOutputUnit() {
        return outputUnit;
    }
}
