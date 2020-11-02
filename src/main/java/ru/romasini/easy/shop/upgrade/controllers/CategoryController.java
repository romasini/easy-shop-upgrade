package ru.romasini.easy.shop.upgrade.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romasini.easy.shop.upgrade.entities.Category;
import ru.romasini.easy.shop.upgrade.services.CategoryService;

import java.util.List;

@RequestMapping("/api/v1/category")
@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

}
