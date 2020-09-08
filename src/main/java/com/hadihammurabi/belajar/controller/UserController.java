package com.hadihammurabi.belajar.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.hadihammurabi.belajar.model.User;
import com.hadihammurabi.belajar.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
  public List<User> index() {
    return this.userService.getUsers();
  }

  @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
  public User create(@RequestBody User user) {
    return this.userService.createUser(user);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") UUID id) {
    this.userService.deleteUser(id);
    return "Data has been deleted.";
  }

}
