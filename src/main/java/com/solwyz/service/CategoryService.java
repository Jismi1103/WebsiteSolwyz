package com.solwyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.entity.Category;
import com.solwyz.exception.ResourceNotFoundException;
import com.solwyz.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public void deleteCategoryById(Long id) {
		if (!categoryRepository.existsById(id)) {
			throw new RuntimeException("Category not found with id: " + id);
		}
		categoryRepository.deleteById(id);
	}

	public Category updateCategory(Long id, Category updatedCategory) {
		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(id + " does not exist"));

		existingCategory.setName(updatedCategory.getName());

		return categoryRepository.save(existingCategory);
	}

	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
	}

}
