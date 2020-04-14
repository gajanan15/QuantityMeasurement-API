package com.bridgelabz.quantitymeasurement.enumeration;

public enum SubTypes {
    FEET(Units.LENGTH), INCH(Units.LENGTH),
    YARD(Units.LENGTH), CENTIMETER(Units.LENGTH),

    GALLON(Units.VOLUME), LITRE(Units.VOLUME), MILLILITRE(Units.VOLUME),
    KILOGRAM(Units.WEIGHT), GRAM(Units.WEIGHT), TONNE(Units.WEIGHT),
    FAHRENHEIT(Units.TEMPERATURE), CELSIUS(Units.TEMPERATURE);

    public Units units;

    SubTypes(Units units) {
        this.units = units;
    }
}
