package com.example.labresponseentity.service;

import com.example.labresponseentity.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    public List<Task> getAllTasks() {

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Learn Java"));
        tasks.add(new Task(2, "Spring Boot"));
        tasks.add(new Task(3, "Database"));
        tasks.add(new Task(4, "Do Homework"));

        return tasks;
    }

}
