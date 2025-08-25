package com.spring.MBS_CRUD_Operation.model;

public class Response {

    private int httpStatus;
    private String message;
    private Object payload;

    public Response(int httpStatus, String message, Object payload){

        this.httpStatus=httpStatus;
        this.message=message;
        this.payload=payload;
    }

    public Response() {
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
