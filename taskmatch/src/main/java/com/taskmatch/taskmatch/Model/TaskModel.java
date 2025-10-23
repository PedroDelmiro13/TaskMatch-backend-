package com.taskmatch.taskmatch.Model;

import com.taskmatch.taskmatch.Enum.CategoryTask;
import com.taskmatch.taskmatch.Enum.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {
    @Id
    private String taskId;  //
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private String providerId;
    @NotNull
    private List<LocalDateTime> availableSlots;
    @NotNull
    private TaskStatus status;
    @NotNull
    private Double price;
    @NotNull
    private CategoryTask category;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
