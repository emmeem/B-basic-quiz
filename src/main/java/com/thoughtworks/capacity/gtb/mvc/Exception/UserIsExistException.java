package com.thoughtworks.capacity.gtb.mvc.Exception;

public class UserIsExistException extends RuntimeException {
    public UserIsExistException(String message) {
        super(message);
    }
}
