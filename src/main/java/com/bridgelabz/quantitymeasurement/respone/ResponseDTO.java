package com.bridgelabz.quantitymeasurement.respone;

public class ResponseDTO {
    public int statusCode;
    public String message;
    public Object data;

    public ResponseDTO(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}

