package com.hadihammurabi.belajar.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.hadihammurabi.belajar.model.Task;
import com.hadihammurabi.belajar.model.User;
import com.hadihammurabi.belajar.service.TaskService;
import com.hadihammurabi.belajar.service.UserService;

@RequestMapping("/tasks")
@RestController
public class TaskController {
  private TaskService taskService;
  private UserService userService;

  @Autowired
  public TaskController(TaskService taskService, UserService userService) {
    this.taskService = taskService;
    this.userService = userService;
  }

  @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
  public Task create(@RequestBody TaskForm taskInput) {
    User owner = this.userService.getUser(taskInput.getOwner_id());
    Task task = new Task();
    task.setTitle(taskInput.getTitle());
    task.setDescription(taskInput.getDescription());
    task.setOwner(owner);
    return this.taskService.createTask(task);
  }

  @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
  public List<Task> index() {
    return this.taskService.getTasks();
  }

  static class TaskForm {
    String title;
    String description;
    UUID owner_id;

    TaskForm() {}

    void setTitle(String title) {
      this.title = title;
    }
    String getTitle() {
      return this.title;
    }

    void setDescription(String description) {
      this.description = description;
    }
    String getDescription() {
      return this.description;
    }

    void setOwner_id(UUID ownerId) {
      this.owner_id = ownerId;
    }
    UUID getOwner_id() {
      return this.owner_id;
    }
  }

}
