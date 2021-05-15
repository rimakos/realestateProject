package com.example.demo.service.files;

public class FileUploadException extends RuntimeException {
    public FileUploadException() {

    }

    public FileUploadException(String message) {
        super(message);
    }
}
