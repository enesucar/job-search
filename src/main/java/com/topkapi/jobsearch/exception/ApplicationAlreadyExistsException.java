package com.topkapi.jobsearch.exception;

public class ApplicationAlreadyExistsException extends RuntimeException{
    public ApplicationAlreadyExistsException(String message) {
        super(message);
    }
}
