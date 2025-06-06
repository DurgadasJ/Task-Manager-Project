package com.js.java.config;

import com.js.java.model.Task;
import com.js.java.service.TaskFormatter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SimpleTaskFormatter implements TaskFormatter {

    @Override
    public String format(Task task) {
        return "Simple Task Formatter Default" + task.getTaskId();
    }
}
