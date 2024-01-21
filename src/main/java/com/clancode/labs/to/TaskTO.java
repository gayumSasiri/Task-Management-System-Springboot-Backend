package com.clancode.labs.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTO implements Serializable {
    @Null(message = "Task id should not be null")
    Integer taskId;
    @NotBlank(message = "task title cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid title")
    String title;
    @NotBlank(message = "task description cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid description")
    String description;
    @NotBlank(message = "Task id should not be blank")
    String userId;


    public TaskTO(String title, String description, String userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }
}
