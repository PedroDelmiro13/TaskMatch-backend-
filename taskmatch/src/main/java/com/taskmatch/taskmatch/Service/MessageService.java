package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.MessageRequestDTO;
import com.taskmatch.taskmatch.DTO.MessageResponseDTO;
import com.taskmatch.taskmatch.DTO.MessageUpdateDTO;
import com.taskmatch.taskmatch.Exception.MessageNotFoundException;
import com.taskmatch.taskmatch.Mapper.MessageMapper;
import com.taskmatch.taskmatch.Model.MessageModel;
import com.taskmatch.taskmatch.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper mapper;

    public MessageResponseDTO getMessage(String messageId) {
        MessageModel message = messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
        return mapper.toDTO(message);
    }

    public List<MessageResponseDTO> getAllMessages() {
        return messageRepository.findAllByIsDeletedIsFalse()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MessageResponseDTO createMessage(MessageRequestDTO dto) {
        MessageModel message = mapper.toEntity(dto);
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        message.setIsDeleted(false);
        return mapper.toDTO(messageRepository.save(message));
    }

    public MessageResponseDTO updateMessage(String messageId, MessageUpdateDTO dto) {
        MessageModel message = messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
        mapper.updateFromDto(dto, message);
        message.setUpdatedAt(LocalDateTime.now());
        return mapper.toDTO(messageRepository.save(message));
    }

    public MessageResponseDTO deleteMessage(String messageId) {
        MessageModel message = messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
        message.setIsDeleted(true);
        return mapper.toDTO(messageRepository.save(message));
    }
}
