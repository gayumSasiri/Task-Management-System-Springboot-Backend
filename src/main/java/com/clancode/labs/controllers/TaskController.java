package com.clancode.labs.controllers;

import com.clancode.labs.model.Task;
import com.clancode.labs.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping(value = "/tasks", produces = "application/json")
    public List<Task> getTask(){
        return taskService.getTasks();
    }
}
