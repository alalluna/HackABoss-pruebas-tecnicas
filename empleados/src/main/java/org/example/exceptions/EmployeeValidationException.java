package org.example.exceptions;
//creacion de la clase Exception
public class EmployeeValidationException extends Exception {
    public EmployeeValidationException(String message) {
        super(message);
    }
}
