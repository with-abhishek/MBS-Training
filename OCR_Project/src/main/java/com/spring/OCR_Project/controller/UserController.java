package com.spring.OCR_Project.controller;

import com.spring.OCR_Project.service.UserService;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/savefile")
    public ResponseEntity<String> savefile(@RequestParam("file") MultipartFile file) throws IOException {
        userService.saveFileForOcr(file);
        return ResponseEntity.ok("File uploaded Successfully");
    }

    @GetMapping("/file/ocr/{id}")
    public ResponseEntity<String> extractFromStored(@PathVariable Long id) throws IOException, TesseractException {
        String text = userService.getFileCardData(id);
        return ResponseEntity.ok(text != null ? text : "No File uploaded.");
    }

//    @PostMapping("/file/ocr")
//    public ResponseEntity<String> extractDirectly(@RequestParam("file") MultipartFile file) throws IOException, TesseractException {
//        String text = userService.processAadhaarFile(file);
//        return ResponseEntity.ok(text);
//    }

}
