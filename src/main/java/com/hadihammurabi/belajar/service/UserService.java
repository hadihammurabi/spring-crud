package com.hadihammurabi.belajar.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.hadihammurabi.belajar.model.User;
import com.hadihammurabi.belajar.repository.UserRepository;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return this.userRepository.save(user);
  }

  public List<User> getUsers() {
    return this.userRepository.findAll();
  }

  public User getUser(UUID id) {
    return this.userRepository.findById(id);
  }

  public void deleteUser(UUID id) {
    User user = this.getUser(id);
    this.userRepository.delete(user);
  }
}
