package com.js.java.exception;


public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super(message);
    }
}
