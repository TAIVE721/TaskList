package com.nekotasks.arc.mappers;

import com.nekotasks.arc.domain.dto.TaskDto;
import com.nekotasks.arc.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
