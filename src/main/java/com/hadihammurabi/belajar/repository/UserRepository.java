package com.hadihammurabi.belajar.repository;

import java.util.List;
import java.util.UUID;

import com.hadihammurabi.belajar.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
