package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.TaskDTO;
import com.taskmatch.taskmatch.DTO.TaskUpdateDTO;
import com.taskmatch.taskmatch.Enum.TaskStatus;
import com.taskmatch.taskmatch.Exception.TaskNotFoundException;
import com.taskmatch.taskmatch.Model.TaskModel;
import com.taskmatch.taskmatch.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskModel createTask(TaskDTO dto) {
        TaskModel task = new TaskModel();
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setPrice(dto.getPrice());
        task.setCategory(dto.getCategory());
        task.setStatus(TaskStatus.ACTIVE);
        task.setAvailableSlots(dto.getAvailableSlots());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public TaskModel updateTask(String taskId, TaskUpdateDTO dto) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        if (dto.getDescription() != null && !dto.getDescription().isBlank()) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getTitle() != null && !dto.getTitle().isBlank()) {
            task.setTitle(dto.getTitle());
        }
        if (dto.getPrice() != null) {
            task.setPrice(dto.getPrice());
        }
        if (dto.getCategory() != null) {
            task.setCategory(dto.getCategory());
        }
        if (dto.getAvailableSlots() != null && !dto.getAvailableSlots().isEmpty()) {
            task.setAvailableSlots(dto.getAvailableSlots());
        }

        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public TaskModel getTask(String taskId) {
        return taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    public List<TaskModel> getAllTask() {
        return taskRepository.findAllByStatusNot(TaskStatus.DELETED);
    }

    public TaskModel deleteTask(String taskId) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDeletedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.DELETED);
        return taskRepository.save(task);
    }

    public TaskModel markAsCompleted(String taskId) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setStatus(TaskStatus.COMPLETED);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}
