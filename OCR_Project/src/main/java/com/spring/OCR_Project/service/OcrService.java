package com.spring.OCR_Project.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OcrService {

    @Value("${tesseract.datapath}")
    private String tessDataPath;

    private static final int MIN_WIDTH = 100;

    public String extractTextFromImage(MultipartFile file) throws IOException, TesseractException {
        // Create temp file and transfer MultipartFile
        Path tempFile = Files.createTempFile("tempImage", file.getOriginalFilename());
        file.transferTo(tempFile.toFile());

        // Read image
        BufferedImage image = ImageIO.read(tempFile.toFile());
        if (image == null) {
            Files.deleteIfExists(tempFile);
            throw new IOException("Uploaded file is not a valid image");
        }

        // Resize if too small
        if (image.getWidth() < MIN_WIDTH) {
            int newWidth = MIN_WIDTH;
            int newHeight = (newWidth * image.getHeight()) / image.getWidth();
            image = resizeImage(image, newWidth, newHeight);
        }

        // Initialize Tesseract
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        tesseract.setLanguage("eng");
        tesseract.setTessVariable("user_defined_dpi", "300");


        String result = tesseract.doOCR(image);
        Files.deleteIfExists(tempFile);

        return result;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics.dispose();
        return resizedImage;
    }
}
