package com.clancode.labs.services;

import com.clancode.labs.model.Task;
import com.clancode.labs.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public boolean existById(Integer id) {
        return taskRepository.existsById(id);
    }

    public Optional<Task> getTaskById(Integer id){
        return taskRepository.findById(id);
    }
}
