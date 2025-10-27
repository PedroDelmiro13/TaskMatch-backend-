package com.taskmatch.taskmatch.Mapper;

import com.taskmatch.taskmatch.DTO.TaskRequestDTO;
import com.taskmatch.taskmatch.DTO.TaskResponseDTO;
import com.taskmatch.taskmatch.DTO.TaskUpdateDTO;
import com.taskmatch.taskmatch.Model.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskModel toEntity(TaskRequestDTO dto);
    TaskResponseDTO toDTO(TaskModel task);

    void updateFromDto(TaskUpdateDTO dto, @MappingTarget TaskModel task);
}
