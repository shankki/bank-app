package com.bankapp.portal.dto;

import org.springframework.http.HttpStatus;

public class SuccessResponseDto {

    private Object data;
    private String message;

    public SuccessResponseDto(){

    }

    public SuccessResponseDto(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
