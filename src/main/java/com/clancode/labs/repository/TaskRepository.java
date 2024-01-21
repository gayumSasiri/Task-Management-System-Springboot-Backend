package com.clancode.labs.repository;

import com.clancode.labs.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(value = "SELECT * FROM task WHERE user_id = :userId", nativeQuery = true)
    List<Task> findAllTaskByUserId (Integer userId);
}
