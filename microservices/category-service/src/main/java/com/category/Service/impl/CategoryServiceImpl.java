package com.category.Service.impl;

import com.category.Model.Category;
import com.category.Repository.CategoryRepository;
import com.category.Service.CategoryService;
import com.category.dto.SalonDTO;
import com.category.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category category1 = new Category();
        category1.setName(category.getName());
        category1.setSalonId(salonDTO.getId());
        category1.setImage(category.getImage());
        return categoryRepository.save(category1);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category==null){
            throw new ResourceNotFoundException("Category doesn't exist with id" + id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
        Category category = getCategoryById(id);
        if(category==null){
            throw new ResourceNotFoundException("Category doesn't exist with id" + id);
        }

        if(category.getSalonId().equals(salonId)){
            categoryRepository.deleteById(id);
        }
        throw new Exception("Yo can't perform this request");
    }
}
