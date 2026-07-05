package com.example.labresponseentity.service;

import com.example.labresponseentity.model.Task;
import com.example.labresponseentity.model.User;
import com.example.labresponseentity.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public boolean addTask(Task task) {

        User user = userService.findUserById(task.getAssignedTo());

        if (user == null) {
            return false;
        }

        taskRepository.save(task);
        return true;
    }

    public Task findById(int id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(int id, Task task) {
        return taskRepository.save(id, task);
    }

    public Task deleteTask(int id) {
        return taskRepository.deleteById(id);
    }
}