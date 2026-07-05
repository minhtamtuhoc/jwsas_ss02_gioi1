package com.example.labresponseentity.repository;

import com.example.labresponseentity.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public Task save(Task task) {
        tasks.add(task);
        return task;
    }

    public Task save(int id, Task newTask) {

        for (int i = 0; i < tasks.size(); i++) {

            if (tasks.get(i).getId() == id) {

                newTask.setId(id);

                tasks.set(i, newTask);

                return newTask;
            }
        }

        return null;
    }

    public Task deleteById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {

                tasks.remove(task);

                return task;
            }
        }

        return null;
    }

}