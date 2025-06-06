package com.js.java.controller;

import com.js.java.model.Task;
import com.js.java.model.TaskRequest;
import com.js.java.service.TaskFormatter;
import com.js.java.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TaskControllerTest {

    @Test
    void testSubmitWithSimpleFormatter(){
        TaskServiceImpl mockService = mock(TaskServiceImpl.class);

        TaskFormatter simpleFormatter = task -> "Simple Task Formatter Default" ;
        TaskFormatter defaultFormatter = task -> "Detailed Task Formatter " ;
        TaskController taskController = new TaskController(mockService,simpleFormatter,defaultFormatter);
        TaskRequest taskRequest = new TaskRequest();

        ResponseEntity<String> response =taskController.submitSimpleFormatter(taskRequest);

        verify(mockService).submitTask(eq(taskRequest),any());
        assertEquals("Task submitted by Simple Formatter", response.getBody());
    }

    @Test
    void testGetAllTasks(){
        TaskServiceImpl mockService = mock(TaskServiceImpl.class);
        Task task = new Task();
        task.setTaskId("123");
        task.setStatus("COMPLETED");
        task.setDescription("Sample Task");

        when(mockService.getAllTasks()).thenReturn(Collections.singletonList(task));

        TaskController taskController = new TaskController(mockService,t->" ",t->" ");
        ResponseEntity<List<Task>> response = taskController.getAllTask();

        assertEquals(1, response.getBody().size());

        
    }
}
