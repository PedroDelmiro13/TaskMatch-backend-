package com.taskmatch.taskmatch.DTO;

import com.taskmatch.taskmatch.Enum.CategoryTask;
import com.taskmatch.taskmatch.Enum.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDTO {
    private String title;
    private String description;
    private List<LocalDateTime> availableSlots;
    private Double price;
    private CategoryTask category;
}
