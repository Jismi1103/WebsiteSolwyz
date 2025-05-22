package com.solwyz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category save(Category category);

	

	List<Category> findAll();

	

	

}
