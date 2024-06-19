package com.quizwiz.quizwizbackend.repository;

import com.quizwiz.quizwizbackend.entities.exam.Question;
import com.quizwiz.quizwizbackend.entities.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
