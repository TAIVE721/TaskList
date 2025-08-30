package com.nekotasks.arc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nekotasks.arc.domain.dto.TaskListDto;
import com.nekotasks.arc.domain.entities.Tasklist;
import com.nekotasks.arc.mappers.TaskListMapper;
import com.nekotasks.arc.services.TaskListService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping()
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists().stream().map(taskListMapper::toDto).toList();
    }

    @PostMapping("path")
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        Tasklist createdTaskList = taskListService.createTaskLis(taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(createdTaskList);

    }

}
