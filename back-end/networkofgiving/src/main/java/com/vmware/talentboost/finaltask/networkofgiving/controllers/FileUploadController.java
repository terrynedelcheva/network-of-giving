package com.vmware.talentboost.finaltask.networkofgiving.controllers;

import com.vmware.talentboost.finaltask.networkofgiving.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("charities/images")
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        return storageService.store(file);
    }
}
