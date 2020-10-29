package ru.romasini.easy.shop.upgrade.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.upgrade.entities.Category;
import ru.romasini.easy.shop.upgrade.repositories.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    };
}
