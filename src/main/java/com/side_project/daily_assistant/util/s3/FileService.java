package com.side_project.daily_assistant.util.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.side_project.daily_assistant.util.ValueCheck.valueNullOrEmpty;


@Service
@RequiredArgsConstructor
public class FileService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    /**
     * 여러 MultipartFile에 대한 PUT presigned URL과 GET URL을 동시에 생성하는 메서드
     *
     * @param images 파일 리스트
     * @param folderPath S3 폴더 경로 (예: board-image/imageFolderUUID)
     * @return PUT presigned URL 리스트, GET URL 리스트를 포함한 imageUrlsResult 객체
     */
    public imageUrlsResult generatePreSignedPutUrlsAndGetUrls(List<MultipartFile> images, String folderPath) {
        List<String> prePutSignedUrls = new ArrayList<>();
        List<String> getImageUrls = new ArrayList<>();

        for (MultipartFile image : images) {
            String fileName = image.getOriginalFilename();
            String fullFilePath = createPath(folderPath, fileName);

            String putPreSignedUrl = getPutPreSignedUrl(fullFilePath);
            prePutSignedUrls.add(putPreSignedUrl);

            String getImageUrl = getFileUrl(fullFilePath);
            getImageUrls.add(getImageUrl);
        }

        return new imageUrlsResult(prePutSignedUrls, getImageUrls);
    }

    @Getter
    public static class imageUrlsResult {
        private final List<String> prePutSignedUrls;
        private final List<String> getImageUrls;

        public imageUrlsResult(List<String> prePutSignedUrls, List<String> getImageUrls) {
            this.prePutSignedUrls = prePutSignedUrls;
            this.getImageUrls = getImageUrls;
        }
    }

    /**
     * 파일의 GET presigned url 반환
     *
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return 파일의 GET presigned url
     */
    private String getFileUrl(String fullFilePath) {
        return amazonS3.getUrl(bucket, fullFilePath).toString();
    }

    /**
     * 파일의 PUT presigned url 반환
     *
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return 파일의 PUT presigned url
     */
    private String getPutPreSignedUrl(String fullFilePath) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = getGeneratePutPreSignedUrlRequest(bucket, fullFilePath);
        URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * 파일 업로드용(PUT) presigned url 생성
     *
     * @param bucket   버킷 이름
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return 파일의 PUT presigned url
     */
    private GeneratePresignedUrlRequest getGeneratePutPreSignedUrlRequest(String bucket, String fullFilePath) {
        bucketAndFileNameValidCheck(bucket);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucket, fullFilePath)
                        .withMethod(HttpMethod.PUT)
                        .withExpiration(getPreSignedUrlExpiration());
        generatePresignedUrlRequest.addRequestParameter(
                Headers.S3_CANNED_ACL,
                CannedAccessControlList.PublicRead.toString());
        return generatePresignedUrlRequest;
    }

    /**
     * presigned url 유효 기간 설정
     *
     * @return 유효기간
     */
    private Date getPreSignedUrlExpiration() {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 2; //2분
        expiration.setTime(expTimeMillis);
        return expiration;
    }

    /**
     * 파일 고유 ID를 생성
     *
     * @return 36자리의 UUID
     */
    private String createFileId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 파일의 전체 경로를 생성
     *
     * @param prefix 디렉토리 경로
     * @return 파일의 전체 경로
     */
    public String createPath(String prefix, String fileName) {
        prefixAndFileNameValidCheck(prefix, fileName);
        String fileId = createFileId();
        return String.format("%s/%s", prefix, fileId + fileName);
    }

    private void prefixAndFileNameValidCheck(String prefix, String fileName) {
        if (valueNullOrEmpty(prefix) || valueNullOrEmpty(fileName)) {
            new CustomException(ErrorCode.BAD_REQUEST_PARAMETER);
        }
    }

    private void bucketAndFileNameValidCheck(String bucket) {
        if (valueNullOrEmpty(bucket)) {
            new CustomException(ErrorCode.BAD_REQUEST_PARAMETER);
        }
    }
}
