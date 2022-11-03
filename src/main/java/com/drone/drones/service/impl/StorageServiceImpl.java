package com.drone.drones.service.impl;

import com.drone.drones.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final int CONTENT = 1;

    @Override
    public String saveImage(String image, String... directory) throws IOException {
        log.debug("Save image to {}", (Object) directory);
        byte[] decodedBytes = decode(image);
        StringBuilder imagesDirectory = createDirectory(directory);
        String relativePath = imagesDirectory + UUID.randomUUID().toString().replaceAll("-", "") +"." + getAttachmentType(image);;
        Path path = Paths.get(relativePath);
        log.info("Writing image to {}", path);
        Files.write(path, decodedBytes);
        return relativePath;
    }

    private StringBuilder createDirectory(String[] directory) {
        StringBuilder attachmentDirectory = new StringBuilder("images/");
        for (String dir: directory) {
            attachmentDirectory.append(dir).append("/");
        }

        File fullPath = new File("" + attachmentDirectory);
        if (!fullPath.exists()) {
            fullPath.mkdirs();
        }
        return attachmentDirectory;
    }
    private byte[] decode(String image) {
        String[] base64Code = image.split(",");
        return Base64.getDecoder().decode(base64Code[CONTENT]);
    }

    private String getAttachmentType(String attachment) {
        String[] base64Code = attachment.split(",");
        return base64Code[0].substring(base64Code[0].indexOf("/") + 1, base64Code[0].indexOf(";"));
    }
}