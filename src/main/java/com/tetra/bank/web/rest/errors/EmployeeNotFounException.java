package com.tetra.bank.web.rest.errors;

public class EmployeeNotFounException extends RuntimeException {
    public EmployeeNotFounException(Long id) {
        super("Could not find employee with id " + id);
    }
}
