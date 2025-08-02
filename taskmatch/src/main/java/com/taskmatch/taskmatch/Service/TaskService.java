package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.TaskDTO;
import com.taskmatch.taskmatch.Exception.TaskNotFoundException;
import com.taskmatch.taskmatch.Model.TaskModel;
import com.taskmatch.taskmatch.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskModel createTask (TaskDTO dto){
        TaskModel task = new TaskModel();
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setPrice(dto.getPrice());
        task.setCategory(dto.getCategory());
        task.setIsActive(dto.getIsActive());
        task.setAvailableSlots(dto.getAvailableSlots());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
    public TaskModel updateTask (String taskId, TaskDTO dto){
        TaskModel task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setPrice(dto.getPrice());
        task.setCategory(dto.getCategory());
        task.setAvailableSlots(dto.getAvailableSlots());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
    public TaskModel getTask(String taskId){
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }
    public TaskModel deleteTask(String taskId){
        TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDeletedAt(LocalDateTime.now());
        task.setIsActive(false);
        return taskRepository.save(task);
    }
}
