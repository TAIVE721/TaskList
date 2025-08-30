package com.nekotasks.arc.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nekotasks.arc.domain.entities.Tasklist;
import com.nekotasks.arc.repositories.TaskListRepository;
import com.nekotasks.arc.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Tasklist> listTaskLists() {

        return taskListRepository.findAll();
    }

    @Override
    public Tasklist createTaskLis(Tasklist taskList) {
        if (null != taskList.getId()) {
            throw new IllegalArgumentException("Task List already has an ID");
        }

        if (null != taskList.getTitle() || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task List title must be present!");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new Tasklist(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now

        ));

    }

}
