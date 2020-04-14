package com.bridgelabz.quantitymeasurement.Excepion;

public class QuantityMeasurementException extends RuntimeException {
    public ExceptionType type;

    public enum ExceptionType {
        UNIT_TYPE_DOES_NOT_EXIST
    }
    public QuantityMeasurementException(String message, ExceptionType  type) {
        super(message);
        this.type = type;
    }
}
