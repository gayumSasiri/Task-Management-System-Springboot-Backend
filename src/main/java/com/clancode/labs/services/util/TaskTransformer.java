package com.clancode.labs.services.util;

import com.clancode.labs.entity.Task;
import com.clancode.labs.to.TaskTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskTransformer {
    private final ModelMapper mapper;

    public TaskTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Task fromTaskTO(TaskTO taskTO) {
        return mapper.map(taskTO, Task.class);
    }

    public TaskTO toTaskTO(Task task) {
        return mapper.map(task, TaskTO.class);
    }

    public List<TaskTO> toTaskTOList(List<Task> taskList) {
        return taskList.stream().map(this::toTaskTO).collect(Collectors.toList());
    }
}
