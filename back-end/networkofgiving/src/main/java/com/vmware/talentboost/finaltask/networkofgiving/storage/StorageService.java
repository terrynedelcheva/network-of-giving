package com.vmware.talentboost.finaltask.networkofgiving.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String store(MultipartFile file);
}
