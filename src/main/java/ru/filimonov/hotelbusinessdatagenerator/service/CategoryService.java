package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Category;
import ru.filimonov.hotelbusinessdatagenerator.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public int count() {
        return (int) categoryRepository.count();
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
