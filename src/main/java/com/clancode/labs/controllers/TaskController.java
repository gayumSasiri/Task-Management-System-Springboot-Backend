package com.clancode.labs.controllers;

import com.clancode.labs.model.Task;
import com.clancode.labs.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin("*")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping( produces = "application/json")
    public List<Task> getTask(){
        return taskService.getTasks();
    }

    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task taskPara, @PathVariable Integer id){
         if(taskService.existById(id)) {
            Task existingTask = taskService.getTaskById(id).orElseThrow(()-> new EntityNotFoundException("Requested task not found"));
            existingTask.setTitle(taskPara.getTitle());
            existingTask.setDescription(taskPara.getDescription());
            existingTask.setDueDate(taskPara.getDueDate());

            taskService.save(existingTask);
            return ResponseEntity.ok().body(existingTask);
         }else {
             HashMap<String, String> message = new HashMap<>();
             message.put("message ", id + "task not found or matched");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
         }
    }
}
