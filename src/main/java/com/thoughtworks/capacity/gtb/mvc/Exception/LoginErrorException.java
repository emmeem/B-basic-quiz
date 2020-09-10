package com.thoughtworks.capacity.gtb.mvc.Exception;

public class LoginErrorException extends RuntimeException {
    public LoginErrorException(String message) {
        super(message);
    }
}
