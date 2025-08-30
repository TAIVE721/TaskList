package com.nekotasks.arc.mappers;

import com.nekotasks.arc.domain.dto.TaskListDto;
import com.nekotasks.arc.domain.entities.Tasklist;

public interface TaskListMapper {

    Tasklist fromDto(TaskListDto taskListDto);

    TaskListDto toDto(Tasklist tasklist);

}
