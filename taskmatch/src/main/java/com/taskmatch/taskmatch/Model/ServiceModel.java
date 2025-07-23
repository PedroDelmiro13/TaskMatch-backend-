package com.taskmatch.taskmatch.Model;

import com.taskmatch.taskmatch.Enum.CategoryService;
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

@Document(collection = "service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {
    @Id
    private String serviceId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String providerId;
    @NotNull
    private List<LocalDateTime> availableSlots;
    @NotNull
    private Boolean isActive;
    @NotNull
    private Double price;
    @NotNull
    private CategoryService category;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
