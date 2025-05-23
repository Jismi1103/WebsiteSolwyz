package com.solwyz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Designation {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
		private String experience;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


//		public String getTitle() {
//			return title;
//		}
//
//
//		public void setTitle(String title) {
//			this.title = title;
//		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getExperience() {
			return experience;
		}


		public void setExperience(String experience) {
			this.experience = experience;
		}


		public Designation() {
			super();
		
		}
	 
	
	 
}
