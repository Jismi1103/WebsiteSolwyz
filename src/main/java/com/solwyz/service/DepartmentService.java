package com.solwyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.entity.Department;
import com.solwyz.exception.ResourceNotFoundException;
import com.solwyz.repo.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department addCategory(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> getAllCategories() {
		return departmentRepository.findAll();
	}

	public void deleteCategoryById(Long id) {
		if (!departmentRepository.existsById(id)) {
			throw new RuntimeException("department not found with id: " + id);
		}
		departmentRepository.deleteById(id);
	}

	public Department updateCategory(Long id, Department updatedCategory) {
		Department existingCategory = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(id + " does not exist"));

		existingCategory.setName(updatedCategory.getName());

		return departmentRepository.save(existingCategory);
	}

//	public Department getCategoryById(Long id) {
//		return departmentRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("department not found with id: " + id));
//	}

	
	 public Department getDepartmentById(Long id) {
	        return departmentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
	    }

}
