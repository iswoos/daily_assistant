package com.side_project.daily_assistant.util.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

import static com.side_project.daily_assistant.util.ValueCheck.valueNullOrEmpty;


@Service
@RequiredArgsConstructor
public class FileService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    /**
     * 파일의 URL을 반환
     *
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return 파일의 URL
     */
    public String getFileUrl(String fullFilePath) {
        return amazonS3.getUrl(bucket, fullFilePath).toString();
    }

    /**
     * presigned url 발급
     *
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return presigned url
     */
    public String getPutPreSignedUrl(String fullFilePath) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = getGeneratePutPreSignedUrlRequest(bucket, fullFilePath);
        URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * 파일 업로드용(PUT) presigned url 생성
     *
     * @param bucket   버킷 이름
     * @param fullFilePath   버킷 디렉토리 전체 경로
     * @return presigned url
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
