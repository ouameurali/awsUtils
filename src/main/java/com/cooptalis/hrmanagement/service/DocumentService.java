package com.cooptalis.hrmanagement.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.cooptalis.hrmanagement.utils.AwsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class DocumentService {

    private final AwsService awsService;

    public DocumentService(AwsService awsService) {
        this.awsService = requireNonNull(awsService);
    }

    public void getDocumentFromS3(String documentName) {

        AmazonS3 amazonS3Client = awsService.connexionToS3();

        awsService.getFile(amazonS3Client, documentName);
        List<Bucket> buckets = amazonS3Client.listBuckets();
        for (Bucket bucket : buckets) {
            log.info("buckets: {}", bucket);
        }
    }
}

