package com.mishura.service;

public class UserInputException extends IllegalArgumentException{
    public UserInputException() {
    }

    public UserInputException(String s) {
        super(s);
    }
}
