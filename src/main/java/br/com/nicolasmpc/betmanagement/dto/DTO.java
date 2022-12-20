package br.com.nicolasmpc.betmanagement.dto;

import org.springframework.http.HttpStatus;

public abstract class DTO {

    private HttpStatus statusCode;
    private boolean success;

    private String message;

    public DTO() {
    }

    public DTO(HttpStatus statusCode, boolean success) {
        this.statusCode = statusCode;
        this.success = success;
    }

    public DTO(HttpStatus statusCode, boolean success, String message) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
