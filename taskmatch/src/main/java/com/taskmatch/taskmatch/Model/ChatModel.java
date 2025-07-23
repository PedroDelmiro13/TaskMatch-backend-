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

@Document(collection = "chat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatModel {
    @Id
    private String chatId;
    @NotBlank
    private String userId;
    @NotNull
    private LocalDateTime createdAt;
}
