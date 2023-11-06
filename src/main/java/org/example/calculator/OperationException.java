package org.example.calculator;

public class OperationException extends RuntimeException {

    private static final String message = "Incorrect operation, please, input operation again (+, -, *, /)";


    @Override
    public String toString() {
        return message;
    }
}
