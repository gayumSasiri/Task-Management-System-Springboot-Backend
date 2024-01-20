package com.clancode.labs.repository;

import com.clancode.labs.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Integer> {
}
