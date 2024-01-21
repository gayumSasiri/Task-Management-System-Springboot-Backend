package com.clancode.labs.services.custom;

import com.clancode.labs.to.TaskTO;

import java.util.List;

public interface TaskService {

    TaskTO saveTask(TaskTO taskTO);
    void updateTask(TaskTO taskTO);
    void deleteTask(Integer taskId);
    TaskTO getTaskDetails(Integer taskId);
    List<TaskTO> getTaskList(Integer userId);
}
