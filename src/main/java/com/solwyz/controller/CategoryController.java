package com.solwyz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwyz.entity.Category;
import com.solwyz.pojo.response.ApiResponse;
import com.solwyz.service.CategoryService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
	    List<Category> categories = categoryService.getAllCategories();
	    return ResponseEntity.ok(new ApiResponse<>("success", categories));
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable Long id) {
	    Category category = categoryService.getCategoryById(id);
	    return ResponseEntity.ok(new ApiResponse<>("success", category));
	}


	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategoryById(id);
	        return ResponseEntity.ok("Category deleted successfully.");
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        Category updatedCategory = categoryService.updateCategory(id, category);
	        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	    }
}
