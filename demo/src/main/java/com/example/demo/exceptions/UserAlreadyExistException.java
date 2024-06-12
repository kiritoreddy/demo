package com.example.demo.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(Long id) {
        super("User with id " + id + " already exists");
    }
}
