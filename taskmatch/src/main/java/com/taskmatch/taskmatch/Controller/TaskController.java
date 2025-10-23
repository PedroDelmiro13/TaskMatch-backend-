package com.taskmatch.taskmatch.Controller;

import com.taskmatch.taskmatch.DTO.TaskDTO;
import com.taskmatch.taskmatch.DTO.TaskUpdateDTO;
import com.taskmatch.taskmatch.Exception.TaskNotFoundException;
import com.taskmatch.taskmatch.Model.TaskModel;
import com.taskmatch.taskmatch.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/{taskId}/get")
    public ResponseEntity<TaskModel>getTask(@PathVariable String taskId){
        TaskModel task = taskService.getTask(taskId);
        return ResponseEntity.ok(task);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?>getAllTask(){
        List<TaskModel> task = taskService.getAllTask();
        return ResponseEntity.ok(task);
    }
    @PatchMapping("/{taskId}/update")
    public ResponseEntity<TaskModel>updateTask (@PathVariable String taskId, @RequestBody @Valid TaskUpdateDTO dto){
        TaskModel task = taskService.updateTask(taskId, dto);
        return ResponseEntity.ok(task);
    }
    @PostMapping("/create")
    public ResponseEntity<TaskModel>create(@RequestBody @Valid TaskDTO dto){
        TaskModel task = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @PatchMapping("/{taskId}/delete")
    public ResponseEntity<TaskModel>delete(@PathVariable String taskId){
        TaskModel task = taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @PatchMapping("/{taskId}/markComplete")
    public ResponseEntity<TaskModel>complete(@PathVariable String taskId){
        TaskModel task = taskService.markAsCompleted(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
