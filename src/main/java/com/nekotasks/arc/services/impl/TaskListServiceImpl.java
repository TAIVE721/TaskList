package com.nekotasks.arc.services.impl;

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

}
