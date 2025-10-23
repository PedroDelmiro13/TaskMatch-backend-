package com.taskmatch.taskmatch.Model;

import com.taskmatch.taskmatch.Enum.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    private String userId;
    @NotBlank
    private String name;
    @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")
    private String cpf;
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
    @NotNull
    private UserRole role;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
