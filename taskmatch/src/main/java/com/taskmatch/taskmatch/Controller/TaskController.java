package com.taskmatch.taskmatch.Controller;

import com.taskmatch.taskmatch.DTO.TaskRequestDTO;
import com.taskmatch.taskmatch.DTO.TaskResponseDTO;
import com.taskmatch.taskmatch.DTO.TaskUpdateDTO;
import com.taskmatch.taskmatch.Model.TaskModel;
import com.taskmatch.taskmatch.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/{taskId}/get")
    public ResponseEntity<TaskResponseDTO>getTask(@PathVariable String taskId){
        TaskResponseDTO task = taskService.getTask(taskId);
        return ResponseEntity.ok(task);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<TaskResponseDTO>>getAllTask(){
        List<TaskResponseDTO> task = taskService.getAllTask();
        return ResponseEntity.ok(task);
    }
    @PatchMapping("/{taskId}/update")
    public ResponseEntity<TaskResponseDTO>updateTask (@PathVariable String taskId, @RequestBody @Valid TaskUpdateDTO dto){
        TaskResponseDTO task = taskService.updateTask(taskId, dto);
        return ResponseEntity.ok(task);
    }
    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO>create(@RequestBody @Valid TaskRequestDTO dto){
        TaskResponseDTO task = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @PatchMapping("/{taskId}/delete")
    public ResponseEntity<TaskResponseDTO>delete(@PathVariable String taskId){
        TaskResponseDTO task = taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @PatchMapping("/{taskId}/markComplete")
    public ResponseEntity<TaskResponseDTO>complete(@PathVariable String taskId){
        TaskResponseDTO task = taskService.markAsCompleted(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
