package com.taskmatch.taskmatch.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
    @Id
    private String messageId;
    @NotBlank
    private String chatId;
    @NotBlank
    private String userId;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
