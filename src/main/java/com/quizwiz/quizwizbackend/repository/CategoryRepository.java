package com.quizwiz.quizwizbackend.repository;

import com.quizwiz.quizwizbackend.entities.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
