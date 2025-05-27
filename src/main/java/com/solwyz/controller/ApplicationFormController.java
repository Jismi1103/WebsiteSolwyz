package com.solwyz.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.solwyz.entity.ApplicationForm;
import com.solwyz.service.ApplicationFormService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/application")
public class ApplicationFormController {

	//private final ApplicationFormService applicationFormService;

	@Autowired
	private ApplicationFormService applicationFormService;
	
	
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApplicationForm> createApplication(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phoneNo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
            @RequestParam String highestQualification,
            @RequestPart("resume") MultipartFile resumeFile) throws IOException {

        ApplicationForm savedApplication = applicationFormService.createApplication(
                name, email, phoneNo, dateOfBirth, highestQualification, resumeFile);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }
}