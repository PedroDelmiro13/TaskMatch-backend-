package com.taskmatch.taskmatch.DTO;

import com.taskmatch.taskmatch.Enum.CategoryTask;
import com.taskmatch.taskmatch.Enum.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private String taskId;
    private String title;
    private String description;
    private String providerId;
    private List<LocalDateTime> availableSlots;
    private TaskStatus status;
    private Double price;
    private CategoryTask category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
