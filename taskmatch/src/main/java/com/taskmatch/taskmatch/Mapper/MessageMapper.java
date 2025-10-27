package com.taskmatch.taskmatch.Mapper;

import com.taskmatch.taskmatch.DTO.MessageRequestDTO;
import com.taskmatch.taskmatch.DTO.MessageResponseDTO;
import com.taskmatch.taskmatch.DTO.MessageUpdateDTO;
import com.taskmatch.taskmatch.Model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageModel toEntity(MessageRequestDTO dto);
    MessageResponseDTO toDTO(MessageModel message);

    void updateFromDto(MessageUpdateDTO dto, @MappingTarget MessageModel message);
}
