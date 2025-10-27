package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.TaskRequestDTO;
import com.taskmatch.taskmatch.DTO.TaskResponseDTO;
import com.taskmatch.taskmatch.DTO.TaskUpdateDTO;
import com.taskmatch.taskmatch.Enum.TaskStatus;
import com.taskmatch.taskmatch.Exception.TaskNotFoundException;
import com.taskmatch.taskmatch.Mapper.TaskMapper;
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

    @Autowired
    private TaskMapper mapper;

    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        TaskModel task = mapper.toEntity(dto);
        task.setStatus(TaskStatus.ACTIVE);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return mapper.toDTO(taskRepository.save(task));
    }

    public TaskResponseDTO updateTask(String taskId, TaskUpdateDTO dto) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        mapper.updateFromDto(dto, task);

        task.setUpdatedAt(LocalDateTime.now());
        return mapper.toDTO(taskRepository.save(task));
    }

    public TaskResponseDTO getTask(String taskId) {
        return mapper.toDTO(taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found")));
    }

    public List<TaskResponseDTO> getAllTask() {
        return taskRepository.findAllByStatusNot(TaskStatus.DELETED).stream()
                .map(mapper::toDTO)
                .toList();
    }

    public TaskResponseDTO deleteTask(String taskId) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDeletedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.DELETED);
        return mapper.toDTO(taskRepository.save(task));
    }

    public TaskResponseDTO markAsCompleted(String taskId) {
        TaskModel task = taskRepository.findByTaskIdAndStatusNot(taskId, TaskStatus.DELETED)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setStatus(TaskStatus.COMPLETED);
        task.setUpdatedAt(LocalDateTime.now());
        return mapper.toDTO(taskRepository.save(task));
    }
}
