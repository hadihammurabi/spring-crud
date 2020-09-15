package com.hadihammurabi.belajar.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.hadihammurabi.belajar.model.Task;
import com.hadihammurabi.belajar.repository.TaskRepository;

@Service
public class TaskService {
  private TaskRepository taskRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task createTask(Task task) {
    return this.taskRepository.save(task);
  }

  public List<Task> getTasks() {
    return this.taskRepository.findAll();
  }
}
