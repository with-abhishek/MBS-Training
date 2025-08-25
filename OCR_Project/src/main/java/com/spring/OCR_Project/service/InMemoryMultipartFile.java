package com.spring.OCR_Project.service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

public class InMemoryMultipartFile implements MultipartFile {
    private final String name;
    private final byte[] content;
    private final String contentType;

    public InMemoryMultipartFile(String name, byte[] content, String contentType) {
        this.name = name;
        this.content = content;
        this.contentType = contentType;
    }

    @Override public String getName() { return name; }
    @Override public String getOriginalFilename() { return name; }
    @Override public String getContentType() { return contentType; }
    @Override public boolean isEmpty() { return content.length == 0; }
    @Override public long getSize() { return content.length; }
    @Override public byte[] getBytes() { return content; }
    @Override public InputStream getInputStream() { return new ByteArrayInputStream(content); }
    @Override public void transferTo(File dest) throws IOException { Files.write(dest.toPath(), content); }
}
