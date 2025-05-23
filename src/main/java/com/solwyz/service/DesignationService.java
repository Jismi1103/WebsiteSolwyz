package com.solwyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.entity.Designation;
import com.solwyz.exception.ResourceNotFoundException;
import com.solwyz.repo.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	public Designation addDesignation(Designation designation) {

		return designationRepository.save(designation);
	}

	public List<Designation> getAllDesignation() {

		return designationRepository.findAll();
	}

	public void deleteDesignationById(Long id) {
		if (!designationRepository.existsById(id)) {
			throw new RuntimeException("Category not found with id: " + id);
		}
		designationRepository.deleteById(id);
	}

	public Designation updateDesignation(Long id, Designation designation) {

		Designation existingdesignation = designationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(id + " does not exist"));

		existingdesignation.setName(designation.getName());
		existingdesignation.setExperience(designation.getExperience());

		return designationRepository.save(existingdesignation);
	}

	public Designation getDesignationById(Long id) {
		return designationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("designation not found with id: " + id));
	}
}
