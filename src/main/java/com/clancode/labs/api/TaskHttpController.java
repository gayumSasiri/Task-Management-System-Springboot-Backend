package com.clancode.labs.api;

import com.clancode.labs.services.custom.TaskService;
import com.clancode.labs.to.TaskTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin("*")
public class TaskHttpController {
    private final TaskService service;

    public TaskHttpController(TaskService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public TaskTO createNewTask(@RequestBody @Validated TaskTO taskTO) {
        return service.saveTask(taskTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "{task-id}", consumes = "application/json")
    public void updateTask (@PathVariable("task-id") Integer taskId,
                            @RequestBody @Validated TaskTO taskTO) {
        taskTO.setTaskId(taskId);
        service.updateTask(taskTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{task-id}")
    public void deleteTask(@PathVariable("task-id") Integer taskId) {
        service.deleteTask(taskId);
    }

    @GetMapping(value = "/{task-id}", produces = "application/json")
    public TaskTO getTask(@PathVariable("task-id") Integer taskId) {
        return service.getTaskDetails(taskId);
    }

    @GetMapping(produces = "application/json")
    public List<TaskTO> getAllTasks(@RequestParam("user-id")Integer userId) {
        return service.getTaskList(userId);
    }
}
