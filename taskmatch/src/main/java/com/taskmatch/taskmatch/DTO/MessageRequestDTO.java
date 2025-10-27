package com.taskmatch.taskmatch.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDTO {
    @NotBlank
    private String chatId;
    @NotBlank
    private String userId;
    @NotBlank
    private String content;
}