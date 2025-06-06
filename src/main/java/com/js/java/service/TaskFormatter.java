package com.js.java.service;

import com.js.java.model.Task;
@FunctionalInterface
public interface TaskFormatter {
    String format(Task task);
}
