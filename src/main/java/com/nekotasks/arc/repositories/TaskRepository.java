package com.nekotasks.arc.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nekotasks.arc.domain.entities.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskListId);

    Optional<Task> finByTaskListIdAndId(UUID taskListId, UUID id);

}
