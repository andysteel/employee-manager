package com.gmail.andersoninfonet.employeemanager.exception;

public class EmployeeNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public EmployeeNotFoundException() {
    }

    /**
     * @param message
     */
    public EmployeeNotFoundException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public EmployeeNotFoundException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public EmployeeNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    
}
