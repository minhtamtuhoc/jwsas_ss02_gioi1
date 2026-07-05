package com.example.labresponseentity.service;

import com.example.labresponseentity.model.Task;
import com.example.labresponseentity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    @Autowired
    private UserService userService;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public boolean addTask(Task task){

        User user = userService.findById(task.getAssignedTo());

        if(user == null){
            return false;
        }

        tasks.add(task);

        return true;
    }

}
