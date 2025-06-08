package com.js.java.service;

import com.js.java.model.Task;

public interface TaskService {

    default String formatStatus(String status){
        return "Task status is: "+status;    
    }
    
    static boolean isCompleted(Task task){
        return "COMPLETED".equalsIgnoreCase(task.getStatus());
    }
}

