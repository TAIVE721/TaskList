package com.nekotasks.arc.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.nekotasks.arc.domain.entities.TaskPriority;
import com.nekotasks.arc.domain.entities.TaskStatus;

public record TaskDto(UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status) {

}
