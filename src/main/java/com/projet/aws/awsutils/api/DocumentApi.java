package com.projet.aws.awsutils.api;

public interface DocumentApi {

    String GET_DOCUMENT_FROM_S3 = "api/v1/document/email";
    void getDocumentFromS3(String documentName);
}
