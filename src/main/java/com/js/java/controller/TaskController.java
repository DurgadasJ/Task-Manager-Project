package com.js.java.controller;

import com.js.java.exception.TaskNotFoundException;
import com.js.java.model.Task;
import com.js.java.model.TaskRequest;
import com.js.java.service.TaskFormatter;
import com.js.java.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;
    private final TaskFormatter simpleTaskFormatter;
    private final TaskFormatter defaultTaskFormatter;

    public TaskController(TaskServiceImpl taskService, TaskFormatter simpleTaskFormatter,
                          @Qualifier("detailedFormatter") TaskFormatter defaultTaskFormatter){
        this.taskService = taskService;
        this.simpleTaskFormatter = simpleTaskFormatter;
        this.defaultTaskFormatter = defaultTaskFormatter;

    }
    @PostMapping
    public ResponseEntity<String> submitTask(@RequestBody TaskRequest request){
         taskService.submitTask(request,task -> "Fomatted Task: " + task.getTaskId());
         return ResponseEntity.ok("Task submitted successfully ");
    }
    @PostMapping("/simple")
    public ResponseEntity<String> submitSimpleFormatter(@RequestBody TaskRequest request){
        taskService.submitTask(request,simpleTaskFormatter);
        return ResponseEntity.ok("Task submitted by Simple Formatter");
    }
    @PostMapping("/default")
    public ResponseEntity<String> submitDefaultFormatter(@RequestBody TaskRequest request){
        taskService.submitTask(request,defaultTaskFormatter);
        return ResponseEntity.ok("Task submitted by Default Formatter");
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id){

        Task task = taskService.getTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return ResponseEntity.ok(task);
    }
}
