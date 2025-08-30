package com.nekotasks.arc.mappers.impl;

import org.springframework.stereotype.Component;

import com.nekotasks.arc.domain.dto.TaskDto;
import com.nekotasks.arc.domain.entities.Task;
import com.nekotasks.arc.mappers.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null, null, null

        );
    };

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus());
    };
}
