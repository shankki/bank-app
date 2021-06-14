package com.bankapp.portal.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponseDto {

    private String errorMessage;
    private HttpStatus httpStatus;
    private int httpStatusCode;


    public ErrorResponseDto(){
        super();
    }

    public ErrorResponseDto(String errorMessage, HttpStatus httpStatus, int httpStatusCode) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public String toString() {
        return "ErrorResponseDto{" +
                "message='" + errorMessage + '\'' +
                ", httpStatus=" + httpStatus +
                ", httpStatusCode=" + httpStatusCode +
                '}';
    }

}
