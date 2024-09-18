package com.side_project.daily_assistant.util;

import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImagesCheck {

    private static final int MAX_IMAGE_COUNT = 40;
    private static final long MAX_TOTAL_IMAGE_SIZE = 100 * 1024 * 1024;

    public static boolean imageListNotNullOrNotEmpty(List<MultipartFile> images){
        return images != null && !images.isEmpty();
    }

    public static boolean imageListNullOrEmpty(List<MultipartFile> images){
        return images == null || images.isEmpty();
    }

    public static boolean imageListSizeMaximum(List<MultipartFile> images){
        if (images.size() > MAX_IMAGE_COUNT) {
            new CustomException(ErrorCode.EXCEEDED_IMAGE_UPLOAD_MAX_COUNT);
        }
        return true;
    }

    public static boolean imageListVolumeSizeMaximum(List<MultipartFile> images){
        long totalSize = 0;
        for (MultipartFile image : images) {
            totalSize += image.getSize();
        }
        if (totalSize > MAX_TOTAL_IMAGE_SIZE) {
            new CustomException(ErrorCode.EXCEEDED_MAX_TOTAL_IMAGE_SIZE);
        }
        return true;
    }
}
