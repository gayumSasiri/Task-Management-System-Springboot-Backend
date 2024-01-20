package com.clancode.labs.repository;

import com.clancode.labs.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(value = "SELECT * FROM task ORDER BY due_date DESC", nativeQuery = true)
    public List<Task> getAllTaskByDueDateDesc();
}
