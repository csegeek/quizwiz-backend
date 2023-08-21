package com.quizwiz.quizwizbackend.repository;

import com.quizwiz.quizwizbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String username);
}
