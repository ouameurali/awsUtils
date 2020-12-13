package com.cooptalis.hrmanagement.controller;

import com.cooptalis.hrmanagement.api.DocumentApi;
import com.cooptalis.hrmanagement.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

@RestController
@Slf4j

public class DocumentController implements DocumentApi {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = requireNonNull(documentService);
    }


    @GetMapping(GET_DOCUMENT_FROM_S3)
    public void getDocumentFromS3(@PathVariable String documentName) {
        documentService.getDocumentFromS3(documentName);
    }
}
