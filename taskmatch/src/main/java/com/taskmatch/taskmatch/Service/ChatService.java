package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.ChatDTO;
import com.taskmatch.taskmatch.Exception.ChatNotFoundException;
import com.taskmatch.taskmatch.Exception.UnauthorizedChatAccessException;
import com.taskmatch.taskmatch.Model.ChatModel;
import com.taskmatch.taskmatch.Repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatModel create(ChatDTO dto) {
        ChatModel chat = new ChatModel();
        chat.setUserId(dto.getUserId());
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    public ChatModel findById(String chatId, String userId) {
        ChatModel chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatNotFoundException("Chat not found"));
        if (!chat.getUserId().equals(userId))
            throw new UnauthorizedChatAccessException("Unauthorized access");
        return chat;
    }

    public List<ChatModel> findByUser(String userId) {
        return chatRepository.findByUserId(userId);
    }

    public void delete(String chatId, String userId) {
        ChatModel chat = findById(chatId, userId);
        chatRepository.delete(chat);
    }
}
