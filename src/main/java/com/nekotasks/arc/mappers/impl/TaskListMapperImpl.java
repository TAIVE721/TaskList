package com.nekotasks.arc.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nekotasks.arc.domain.dto.TaskListDto;
import com.nekotasks.arc.domain.entities.Task;
import com.nekotasks.arc.domain.entities.TaskStatus;
import com.nekotasks.arc.domain.entities.Tasklist;
import com.nekotasks.arc.mappers.TaskListMapper;
import com.nekotasks.arc.mappers.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public Tasklist fromDto(TaskListDto taskListDto) {
        return new Tasklist(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks()).map(tasks -> tasks.stream().map(taskMapper::fromDto).toList())
                        .orElse(null),
                null,
                null);
    }

    @Override
    public TaskListDto toDto(Tasklist taskList) {

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks()).map(List::size).orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks()).map(tasks -> tasks.stream().map(taskMapper::toDto).toList())
                        .orElse(null)

        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if (null == tasks) {
            return null;
        }
        long closedTaskCount = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()).count();

        return (double) closedTaskCount / tasks.size();

    }

}
