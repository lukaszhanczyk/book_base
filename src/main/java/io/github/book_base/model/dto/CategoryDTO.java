package io.github.book_base.model.dto;


import io.github.book_base.model.Category;

public class CategoryDTO {
    private Integer id;
    private String category_name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.category_name = category.getCategory_name();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
