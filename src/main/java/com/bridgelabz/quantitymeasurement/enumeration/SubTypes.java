package com.bridgelabz.quantitymeasurement.enumeration;

public enum SubTypes {
    FEET(1*12.0,Units.LENGTH), INCH(1.0,Units.LENGTH),
    YARD(1*36.0,Units.LENGTH), CENTIMETER(0.4,Units.LENGTH),

    GALLON(1*3.785,Units.VOLUME), LITRE(1.0,Units.VOLUME), MILLILITRE(1.0/1000.0,Units.VOLUME),
    KILOGRAM(1.0,Units.WEIGHT), GRAM(1/1000.0,Units.WEIGHT), TONNE(1*1000.0,Units.WEIGHT),
    FAHRENHEIT((1.0/5.0),Units.TEMPERATURE), CELSIUS((1.8/9.0),Units.TEMPERATURE);

    public Units units;
    public double conversionUnit;

    SubTypes(double conversionUnit,Units units) {
        this.conversionUnit=conversionUnit;
        this.units = units;
    }
}
