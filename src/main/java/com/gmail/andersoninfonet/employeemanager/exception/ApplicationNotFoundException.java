package com.gmail.andersoninfonet.employeemanager.exception;

public class ApplicationNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApplicationNotFoundException() {
    }

    /**
     * @param message
     */
    public ApplicationNotFoundException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApplicationNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApplicationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
