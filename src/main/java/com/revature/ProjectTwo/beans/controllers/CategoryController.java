package com.revature.ProjectTwo.beans.controllers;

import com.revature.ProjectTwo.beans.services.CategoryService;
import com.revature.ProjectTwo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@RestController

public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Category> getCategories(){ return categoryService.getAllCategories();}

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Category getCategoryById(@PathVariable Integer categoryId){
        Optional<Category> optionalCategory = categoryService.getCategoryById(categoryId);
        //TODO: Do the isPresent() check and throw exception if needed
        return optionalCategory.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCategory(Category category){
        categoryService.createCategory((category));
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCategory(Category category){
        categoryService.updateCategory(category);
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCategory(@PathVariable(name = "categoryId") Integer id){ categoryService.deleteById(id);}
}
