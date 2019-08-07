package com.stackroute.SpringBootTask.exceptions;

public class TrackAlreadyExistsException extends Exception {
    public TrackAlreadyExistsException(String message) {
        super(message);
    }
}
