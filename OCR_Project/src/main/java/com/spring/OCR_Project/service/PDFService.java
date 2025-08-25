package com.spring.OCR_Project.service;

import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

@Service
public class PDFService {

    public String extractTextFromPDF(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    public List<String> extractTextFromPDFImages(MultipartFile file, OcrService ocrService)
            throws IOException, TesseractException {

        List<String> ocrResults = new ArrayList<>();

        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300);
                MultipartFile imageFile = createMultipartFileFromImage(image, "page-" + page + ".jpg");
                ocrResults.add(ocrService.extractTextFromImage(imageFile));
            }
        }

        return ocrResults;
    }

    private MultipartFile createMultipartFileFromImage(BufferedImage image, String fileName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] imageBytes = baos.toByteArray();

        return new InMemoryMultipartFile(fileName, imageBytes, "image/jpeg");
    }
}
