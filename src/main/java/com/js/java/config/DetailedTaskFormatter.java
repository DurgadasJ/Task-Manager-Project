package com.js.java.config;

import com.js.java.model.Task;
import com.js.java.service.TaskFormatter;
import org.springframework.stereotype.Component;

@Component("detailedFormatter")
public class DetailedTaskFormatter implements TaskFormatter {

    @Override
    public String format(Task task){
        return "Detailed Task Formatter : " + task.getTaskId()
                + "\nStatus : " + task.getStatus();
    }
}