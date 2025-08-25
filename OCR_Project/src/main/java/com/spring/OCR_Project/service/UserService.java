package com.spring.OCR_Project.service;


import com.spring.OCR_Project.exception.ResourceNotFoundException;
import com.spring.OCR_Project.model.User;
import com.spring.OCR_Project.repository.UserRepository;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private OcrService ocrService;
    @Autowired
    private PDFService pdfService;
    @Autowired
    private UserRepository userRepository;
    public String getFileCardData(Long id) throws IOException, TesseractException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (user.getAadhaarCardPhoto() == null) return null;

        byte[] fileBytes = Base64.getDecoder().decode(user.getAadhaarCardPhoto());
        return extractTextFromBytes(fileBytes);
    }

    public String processAadhaarFile(MultipartFile file) throws IOException, TesseractException {
        return extractTextFromBytes(file.getBytes());
    }

    private String extractTextFromBytes(byte[] fileBytes) throws IOException, TesseractException {
        if (isPDF(fileBytes)) {
            MultipartFile pdfFile = new InMemoryMultipartFile("file.pdf", fileBytes, "application/pdf");
            String text = pdfService.extractTextFromPDF(pdfFile);
            if (text.trim().isEmpty()) {
                List<String> results = pdfService.extractTextFromPDFImages(pdfFile, ocrService);
                return String.join("\n", results);
            }
            return text;
        } else {
            MultipartFile imageFile = new InMemoryMultipartFile("file.jpg", fileBytes, "image/jpeg");
            return ocrService.extractTextFromImage(imageFile);
        }
    }

    private boolean isPDF(byte[] fileBytes) {
        return fileBytes.length > 4 &&
                fileBytes[0] == 0x25 && fileBytes[1] == 0x50 &&
                fileBytes[2] == 0x44 && fileBytes[3] == 0x46;
    }

    public void saveFileForOcr(MultipartFile file) throws IOException {
        String base64 = Base64.getEncoder().encodeToString(file.getBytes());

        User user = new User();
        user.setAadhaarCardPhoto(base64.getBytes());

        userRepository.save(user);
    }

}
