package com.taskmatch.taskmatch.DTO;

import com.taskmatch.taskmatch.Enum.CategoryTask;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class TaskRequestDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private List<LocalDateTime> availableSlots;
    @NotNull
    private Double price;
    @NotNull
    private CategoryTask category;
}
