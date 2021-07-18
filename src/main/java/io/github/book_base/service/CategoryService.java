package io.github.book_base.service;

import io.github.book_base.model.dto.CategoryDTO;
import io.github.book_base.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(){
        this(new CategoryRepository());
    }
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<CategoryDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }
}
