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

import com.solwyz.entity.Designation;
import com.solwyz.pojo.response.ApiResponse;
import com.solwyz.service.DesignationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/designation")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping("/create")
	public ResponseEntity<Designation>addDesignation(@RequestBody Designation designation){
		return ResponseEntity.ok(designationService.addDesignation(designation));
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Designation>>> getAllDesignation() {
	    List<Designation> designations = designationService.getAllDesignation();
	    return ResponseEntity.ok(new ApiResponse<>("success", designations));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Designation>> getDesignationById(@PathVariable Long id) {
		Designation designation = designationService.getDesignationById(id);
	    return ResponseEntity.ok(new ApiResponse<>("success", designation));
	}
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteDesignation(@PathVariable Long id) {
		 designationService.deleteDesignationById(id);
	        return ResponseEntity.ok("Designation deleted successfully.");
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Designation> updateDesignation(@PathVariable Long id, @RequestBody Designation designation) {
		 Designation updatedDesignation = designationService.updateDesignation(id, designation);
	        return new ResponseEntity<>(updatedDesignation, HttpStatus.OK);
	    }

}
