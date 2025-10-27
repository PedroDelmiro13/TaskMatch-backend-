package com.taskmatch.taskmatch.Mapper;

import com.taskmatch.taskmatch.DTO.TaskDTO;
import com.taskmatch.taskmatch.Model.TaskModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskModel toEntity(TaskDTO)
}
