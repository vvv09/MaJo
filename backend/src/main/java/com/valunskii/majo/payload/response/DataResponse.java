package com.valunskii.majo.payload.response;

public class DataResponse {
    private String message;
    private Object data;

    public DataResponse() {
    }

    public DataResponse(String message) {
        this.message = message;
    }

    public DataResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
