package com.quizwiz.quizwizbackend.repository;

import com.quizwiz.quizwizbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUserName(String username);
}
