package com.ibm.exceptions;

public class StandardError {

    private String message;
    private Integer status;

    public StandardError() {
    }

    public StandardError(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer isStatus() {
        return this.status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
