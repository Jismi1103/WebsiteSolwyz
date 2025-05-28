package com.solwyz.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.solwyz.entity.ApplicationForm;
import com.solwyz.repo.ApplicationFormRepository;

@Service
public class ApplicationFormService {

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    public ApplicationForm createApplication(
            String name,
            String email,
            String phoneNo,
            LocalDate dateOfBirth,
            String highestQualification,
            MultipartFile resumeFile) throws IOException {

        // Upload the resume PDF to Cloudinary
        String resumeUrl = cloudinaryService.uploadPdf(resumeFile);

        // Create and save the application form
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setName(name);
        applicationForm.setEmail(email);
        applicationForm.setPhoneNo(phoneNo);
        applicationForm.setDateOfBirth(dateOfBirth);
        applicationForm.setHighestQualification(highestQualification);
        applicationForm.setResumeUrl(resumeUrl);

        return applicationFormRepository.save(applicationForm);
    }
}
