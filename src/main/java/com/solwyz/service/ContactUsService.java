package com.solwyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.entity.ContactUs;
import com.solwyz.repo.ContactUsRepository;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepository contactUsRepository;

	public ContactUs addContact(ContactUs contact) {
		return contactUsRepository.save(contact);
	}

	public List<ContactUs> getAllContacts() {
		return contactUsRepository.findAll();
	}

	 public void deleteContact(Long id) {
	        
	        if(!contactUsRepository.existsById(id)) {
	            throw new RuntimeException("Contact with id " + id + " not found");
	        }
	        contactUsRepository.deleteById(id);
	    }

}
