package com.revature.ProjectTwo.beans.services;

import com.revature.ProjectTwo.beans.repositories.CategoryRepository;
import com.revature.ProjectTwo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id){
        return categoryRepository.findById(id);
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }

}
