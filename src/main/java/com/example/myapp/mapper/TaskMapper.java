package com.example.myapp.mapper;


import com.example.myapp.dto.TaskDto;
import com.example.myapp.model.Task;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "taskId", source = "taskId")
    @Mapping(target = "authorId", source = "author.clientId")
    @Mapping(target = "executorName", source = "executor.name")
    @Mapping(target = "responsibilityName", source = "responsibility.name")
    @Mapping(target = "date", source = "date")
    TaskDto toTaskDto(Task task);
}







