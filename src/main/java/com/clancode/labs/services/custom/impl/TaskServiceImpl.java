package com.clancode.labs.services.custom.impl;

import com.clancode.labs.entity.Task;
import com.clancode.labs.repository.TaskRepository;
import com.clancode.labs.services.custom.TaskService;
import com.clancode.labs.services.util.TaskTransformer;
import com.clancode.labs.to.TaskTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    public final TaskRepository repository;
    public final TaskTransformer transformer;

    @Override
    public TaskTO saveTask(TaskTO taskTO) {
        Task task = transformer.fromTaskTO(taskTO);
        Task savedTask = repository.save(task);
        return transformer.toTaskTO(savedTask);
    }

    @Override
    public void updateTask(TaskTO taskTO) {
        repository.findById(taskTO.getTaskId()).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        Task updatedTask = transformer.fromTaskTO(taskTO);
        repository.save(updatedTask);
    }

    @Override
    public void deleteTask(Integer taskId) {
        Task task = repository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        repository.delete(task);
    }

    @Override
    public TaskTO getTaskDetails(Integer taskId) {
        Optional<Task> optTask = repository.findById(taskId);
        if (optTask.isEmpty()) throw new EntityNotFoundException("Task not found");
        return transformer.toTaskTO(optTask.get());
    }

    @Override
    public List<TaskTO> getTaskList() {
        List<Task> taskList = repository.findAll();
        return transformer.toTaskTOList(taskList);
    }
}
