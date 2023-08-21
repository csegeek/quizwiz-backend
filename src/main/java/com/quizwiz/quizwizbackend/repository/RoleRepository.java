package com.quizwiz.quizwizbackend.repository;

import com.quizwiz.quizwizbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
