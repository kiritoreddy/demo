package com.example.demo.exceptions;

public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(Integer score) {
        super("Score " + score + " is invalid");
    }
}
