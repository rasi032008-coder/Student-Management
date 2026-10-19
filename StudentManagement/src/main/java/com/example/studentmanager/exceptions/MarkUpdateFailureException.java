package com.example.studentmanager.exceptions;

public class MarkUpdateFailureException extends RuntimeException {
    public MarkUpdateFailureException(String message) {
        super(message);
    }

    public MarkUpdateFailureException() {
    }

    @Override
    public String toString() {
        return "MarkUpdateFailure{ " + getMessage() + " }";
    }
}
