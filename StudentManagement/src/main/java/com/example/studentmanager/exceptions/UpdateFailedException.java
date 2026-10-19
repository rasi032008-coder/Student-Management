package com.example.studentmanager.exceptions;

public class UpdateFailedException extends RuntimeException {
    public UpdateFailedException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "UpdateFailedException{" + getMessage()+"}";
    }
}
