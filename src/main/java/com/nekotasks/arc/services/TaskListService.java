package com.nekotasks.arc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.nekotasks.arc.domain.entities.Tasklist;

public interface TaskListService {
    List<Tasklist> listTaskLists();

    Tasklist createTaskLis(Tasklist tasklist);

    Optional<Tasklist> getTaskList(UUID id);

    Tasklist updateTasklist(UUID taskListId, Tasklist taskList);

    void deleteTaskList(UUID taskListId);
}
