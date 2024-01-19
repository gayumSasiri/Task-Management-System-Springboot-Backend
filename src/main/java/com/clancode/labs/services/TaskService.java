package com.clancode.labs.services;

import com.clancode.labs.model.Task;
import com.clancode.labs.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
}
