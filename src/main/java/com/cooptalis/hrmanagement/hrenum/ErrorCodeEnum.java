package com.cooptalis.hrmanagement.hrenum;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {
    CANDIDATE_NOT_FOUND(1, "CANDIDATE_NOT_FOUND", "Candidate doesn't exist.", HttpStatus.NOT_FOUND),
    CANDIDATE_ALREADY_EXIST(2, "CANDIDATE_ALREADY_EXIST", "Candidate already exist, can't to be added.", HttpStatus.CONFLICT),
    SKILLS_NOT_FOUND(3, "SKILLS_NOT_FOUND", "Skills to be added doesn't exist.", HttpStatus.CONFLICT);

    private final int code;
    private final String technicalMessage;
    private final String publicMessage;
    private final HttpStatus httpStatus;

    ErrorCodeEnum(int code, String technicalMessage, String publicMessage, HttpStatus httpStatus) {
        this.code = code;
        this.technicalMessage = technicalMessage;
        this.publicMessage = publicMessage;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public String getPublicMessage() {
        return publicMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
