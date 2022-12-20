package br.com.nicolasmpc.betmanagement.dto;

import org.springframework.http.HttpStatus;

public abstract class DTO {

    private HttpStatus statusCode;
    private boolean success;

    public DTO() {
    }

    public DTO(HttpStatus statusCode, boolean success) {
        this.statusCode = statusCode;
        this.success = success;
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
}
