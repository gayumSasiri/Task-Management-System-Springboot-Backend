package com.clancode.labs.services;

import com.clancode.labs.entity.Task;
import com.clancode.labs.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.getAllTaskByDueDateDesc();
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

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
