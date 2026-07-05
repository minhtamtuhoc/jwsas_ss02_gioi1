package com.example.labresponseentity.controller;

import com.example.labresponseentity.model.Task;
import com.example.labresponseentity.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search) {

        List<Task> tasks = taskService.getAllTasks();

        if (search != null && !search.isBlank()) {
            tasks = tasks.stream()
                    .filter(task -> task.getTitle()
                            .toLowerCase()
                            .contains(search.toLowerCase()))
                    .toList();
        }

        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task newTask) {

        boolean success = taskService.addTask(newTask);

        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable int id,
            @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(
            @PathVariable int id,
            @RequestBody Task task) {

        Task existingTask = taskService.findById(id);

        if (existingTask == null) {
            return ResponseEntity.notFound().build();
        }

        if (task.getTitle() != null) {
            existingTask.setTitle(task.getTitle());
        }

        if (task.getAssignedTo() != 0) {
            existingTask.setAssignedTo(task.getAssignedTo());
        }

        Task updatedTask = taskService.updateTask(id, existingTask);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {

        Task deletedTask = taskService.deleteTask(id);

        if (deletedTask != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}