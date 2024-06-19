package com.quizwiz.quizwizbackend.service;

import com.quizwiz.quizwizbackend.entities.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);
}
