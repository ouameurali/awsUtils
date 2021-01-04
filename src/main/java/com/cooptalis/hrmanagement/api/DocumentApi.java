package com.cooptalis.hrmanagement.api;

public interface DocumentApi {

    String GET_DOCUMENT_FROM_S3 = "api/document/{documentName}";

    void getDocumentFromS3(String documentName);
}
