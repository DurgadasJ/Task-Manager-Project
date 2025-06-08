package com.js.java.util;

import org.springframework.stereotype.Component;

@Component
public class TaskLogger {

    public TaskLogger() {
        System.out.println("TaskLogger initialized");
    }

    public void log(String msg){
        System.out.println("TaskLogger: " + msg);
    }
}
