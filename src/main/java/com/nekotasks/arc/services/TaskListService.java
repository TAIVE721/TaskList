package com.nekotasks.arc.services;

import java.util.List;

import com.nekotasks.arc.domain.entities.Tasklist;

public interface TaskListService {
    List<Tasklist> listTaskLists();

    Tasklist createTaskLis(Tasklist tasklist);

}
