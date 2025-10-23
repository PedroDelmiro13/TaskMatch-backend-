package com.taskmatch.taskmatch.Model;

import com.taskmatch.taskmatch.Enum.PaymentMethod;
import com.taskmatch.taskmatch.Enum.PaymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {
    @Id
    private String paymentId;
    @NotBlank
    private String userId;
    @NotBlank
    private String serviceId;
    private LocalDateTime requestedRefundAt;
    private LocalDateTime refundedAt;
    private String cancelReason;
    @NotNull
    private PaymentMethod method;
    @NotNull
    private PaymentStatus status;
    @NotNull
    private Double value;
    @NotBlank
    private String transactionId;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
