package com.nekotasks.arc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nekotasks.arc.domain.entities.Tasklist;

@Repository
public interface TaskListRepository extends JpaRepository<Tasklist, UUID> {

}
