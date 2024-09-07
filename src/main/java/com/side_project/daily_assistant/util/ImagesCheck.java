package com.side_project.daily_assistant.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImagesCheck {

    public static boolean imageListNotNullOrNotEmpty(List<MultipartFile> images){
        return images != null && !images.isEmpty();
    }

    public static boolean imageListNullOrEmpty(List<MultipartFile> images){
        return images == null || images.isEmpty();
    }
}
