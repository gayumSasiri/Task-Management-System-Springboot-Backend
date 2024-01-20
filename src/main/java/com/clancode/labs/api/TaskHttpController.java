package com.clancode.labs.api;

import com.clancode.labs.entity.Task;
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
public class TaskHttpController {

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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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

    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id){
        return taskService.getTaskById(id).orElseThrow(()-> new EntityNotFoundException("Requested task not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteTask(@PathVariable Integer id){
        if (taskService.existById(id)){
            taskService.deleteTask(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message ", id + "task removed.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message ", id + "task not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
