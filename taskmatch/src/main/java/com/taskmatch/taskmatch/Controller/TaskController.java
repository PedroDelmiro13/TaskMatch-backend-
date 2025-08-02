package com.taskmatch.taskmatch.Controller;

import com.taskmatch.taskmatch.DTO.TaskDTO;
import com.taskmatch.taskmatch.Exception.TaskNotFoundException;
import com.taskmatch.taskmatch.Model.TaskModel;
import com.taskmatch.taskmatch.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/{taskId}/get")
    public ResponseEntity<TaskModel>getTask(@PathVariable @Valid String taskId){
        try{
            TaskModel task = taskService.getTask(taskId);
            return ResponseEntity.ok(task);
        }catch(TaskNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
