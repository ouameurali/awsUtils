package com.cooptalis.hrmanagement.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class AwsService {

    private String bucketName = "documents/";

    public AmazonS3 connexionToS3() {
        AWSCredentials credentials = new BasicAWSCredentials(
                "minioadmin",
                "minioadmin"
        );
        log.info("login into S3 :{}", credentials.getAWSAccessKeyId());
        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:9000", Regions.US_EAST_1.name()))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public void getFile(AmazonS3 s3Client, String documentName) {

        log.info("get File from  S3");
        S3Object s3object = s3Client.getObject(bucketName, documentName);
        S3ObjectInputStream inputStream = s3object.getObjectContent();

        try {
            String pathName = "C:/Users/ouame/Projects/file.pdf";
            IOUtils.copy(inputStream, new FileOutputStream(pathName));
            inputStream.close();
        } catch (IOException e) {
            log.error("error creating file :{}", e.getMessage());
            e.printStackTrace();
        }
    }
}
