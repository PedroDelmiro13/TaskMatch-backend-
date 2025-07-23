package com.taskmatch.taskmatch.Model;

import com.taskmatch.taskmatch.Enum.AppointmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
    @Id
    private String appointmentId;
    @NotNull
    private LocalDateTime scheduling;
    @NotBlank
    private String userId;
    @NotBlank
    private String serviceId;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    @NotNull
    private AppointmentStatus status;
    @NotNull
    private Integer rating;
    @NotBlank
    private String review;
    @NotNull
    private LocalDateTime notified;
}
