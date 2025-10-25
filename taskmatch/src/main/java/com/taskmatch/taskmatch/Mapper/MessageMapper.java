package com.taskmatch.taskmatch.Mapper;

import com.taskmatch.taskmatch.DTO.MessageDTO;
import com.taskmatch.taskmatch.Model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageModel toEntity(MessageDTO dto);
    MessageDTO toDTO(MessageModel message);

    void updateFromDto(MessageDTO dto, @MappingTarget MessageModel message);
}
