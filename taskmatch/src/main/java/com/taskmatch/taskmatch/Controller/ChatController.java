package com.taskmatch.taskmatch.Controller;

import com.taskmatch.taskmatch.DTO.ChatDTO;
import com.taskmatch.taskmatch.Model.ChatModel;
import com.taskmatch.taskmatch.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatModel> create(@Valid @RequestBody ChatDTO dto) {
        ChatModel chat = chatService.create(dto);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<ChatModel> findById(
            @PathVariable String chatId,
            @RequestParam String userId
    ) {
        ChatModel chat = chatService.findById(chatId, userId);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatModel>> findByUser(@PathVariable String userId) {
        return ResponseEntity.ok(chatService.findByUser(userId));
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> delete(
            @PathVariable String chatId,
            @RequestParam String userId
    ) {
        chatService.delete(chatId, userId);
        return ResponseEntity.noContent().build();
    }
}
