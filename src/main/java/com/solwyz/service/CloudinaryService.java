package com.solwyz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;



@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public String uploadFile(MultipartFile file, String resourceType) throws IOException {
        Map<String, Object> options = ObjectUtils.asMap(
                "resource_type", resourceType,         // should be "raw" for PDF
                "type", "upload"                       // ensures public URL
        );
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), options);
        return uploadResult.get("secure_url").toString();
    }


    // Convenience method for images
    public String uploadImage(MultipartFile file) throws IOException {
        return uploadFile(file, "image");
    }

    // Convenience method for PDFs and other raw files
    public String uploadPdf(MultipartFile file) throws IOException {
        return uploadFile(file, "raw");
    }
}
