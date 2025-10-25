package com.taskmatch.taskmatch.Service;

import com.taskmatch.taskmatch.DTO.MessageDTO;
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

    public MessageModel getMessage (String messageId){
        return messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId).
                orElseThrow(() -> new MessageNotFoundException("Message not found"));
    }
    public List<MessageModel> getAllMessages(){
        return messageRepository.findAllByIsDeletedIsFalse();
    }
    public MessageModel createMessage (MessageDTO dto){
        MessageModel message = mapper.toEntity(dto);
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        message.setIsDeleted(false);
        return messageRepository.save(message);
    }
    public MessageModel updateMessage(String messageId, MessageDTO dto) {
        MessageModel message = messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
        mapper.updateFromDto(dto, message);
        message.setUpdatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }
    public MessageModel deleteMessage(String messageId){
        MessageModel message = messageRepository.findByMessageIdAndIsDeletedIsFalse(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
        message.setIsDeleted(true);
        return messageRepository.save(message);
    }
}
