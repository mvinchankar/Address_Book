package com.bridgelabz.AddressBook.services;

public class CustomException extends Exception {

    public enum ExceptionType {
        NODATAINFILE
    }

    ExceptionType type;

    public CustomException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }


    public CustomException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
