package com.clancode.labs.services.custom.impl;

import com.clancode.labs.entity.Task;
import com.clancode.labs.entity.User;
import com.clancode.labs.repository.TaskRepository;
import com.clancode.labs.repository.UserRepository;
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

    public final TaskRepository taskRepository;
    public final TaskTransformer transformer;
    public final UserRepository userRepository;


    @Override
    public TaskTO saveTask(TaskTO taskTO) {
        Task task = transformer.fromTaskTO(taskTO);
        Task savedTask = taskRepository.save(task);
        return transformer.toTaskTO(savedTask);
    }

    @Override
    public void updateTask(TaskTO taskTO) {
        taskRepository.findById(taskTO.getTaskId()).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        Task updatedTask = transformer.fromTaskTO(taskTO);
        taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        taskRepository.delete(task);
    }

    @Override
    public TaskTO getTaskDetails(Integer taskId) {
        Optional<Task> optTask = taskRepository.findById(taskId);
        if (optTask.isEmpty()) throw new EntityNotFoundException("Task not found");
        return transformer.toTaskTO(optTask.get());
    }

    @Override
    public List<TaskTO> getTaskList(Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()){
            if (optUser.get().getRole().equals("ADMIN")){
                List<Task> taskList = taskRepository.findAll();
                return transformer.toTaskTOList(taskList);
            }else {
                List<Task> taskListByUserId = taskRepository.findAllTaskByUserId(userId);
                return transformer.toTaskTOList(taskListByUserId);
            }
        }else {
            throw new EntityNotFoundException("Invalid userId");
        }
    }
}
