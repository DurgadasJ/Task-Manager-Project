package com.js.java.model;

import java.time.LocalDateTime;
import java.util.Optional;

public class Task {
    private String taskId;
    private String description;

    private String status;

    private LocalDateTime localDateTime;

    private Optional<String> result;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Optional<String> getResult() {
        return result;
    }

    public void setResult(Optional<String> result) {
        this.result = result;
    }
}
