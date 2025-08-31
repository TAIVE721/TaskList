package com.nekotasks.arc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nekotasks.arc.domain.dto.TaskListDto;
import com.nekotasks.arc.domain.entities.Tasklist;
import com.nekotasks.arc.mappers.TaskListMapper;
import com.nekotasks.arc.services.TaskListService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID task_list_id) {
        return taskListService.getTaskList(task_list_id).map(taskListMapper::toDto);
    }

    @PutMapping("/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable UUID taskListID, @RequestBody TaskListDto taskListDto) {

        Tasklist updatedTasklist = taskListService.updateTasklist(taskListID, taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(updatedTasklist);

    }

    @DeleteMapping("/{task_list_id}")
    public void deleteTaskList(@PathVariable UUID taskListId) {

        taskListService.deleteTaskList(taskListId);

    }

}
