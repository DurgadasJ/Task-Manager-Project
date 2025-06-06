package com.js.java.service;

import com.js.java.model.Task;
import com.js.java.model.TaskRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final Map<String, Task> taskMap = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void submitTask(TaskRequest request,TaskFormatter taskFormatter) {
        String taskId = UUID.randomUUID().toString();

        Task task = new Task();
        task.setTaskId(taskId);
        task.setDescription(request.getDescription());
        task.setStatus("IN_PROGRESS");
        task.setLocalDateTime(LocalDateTime.now());
        task.setResult(Optional.empty());
        taskMap.put(taskId, task);

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
                task.setStatus("COMPLETED");
                String formattedResult = taskFormatter.format(task);
                task.setResult(Optional.of(formattedResult));
            } catch (InterruptedException e) {
                task.setStatus("FAILED");
                task.setResult(Optional.of("Task failed due to interruption"));

            }
        });
    }

    public List<Task> getAllTasks(){
        return taskMap.values().stream()
                .sorted(Comparator.comparing(Task::getLocalDateTime).reversed())
                .collect(Collectors.toList());
    }

    public Optional<Task> getTaskById(String id){
        return Optional.ofNullable(taskMap.get(id));
    }

}
