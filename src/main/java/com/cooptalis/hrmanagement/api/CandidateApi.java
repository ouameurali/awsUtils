package com.cooptalis.hrmanagement.api;

import com.cooptalis.hrmanagement.dto.CandidateRequestDTO;
import com.cooptalis.hrmanagement.hrexception.HrmException;

public interface CandidateApi {

    String ADD_CANDIDATE = "api/candidate";
    String DELETE_CANDIDATE = "api/candidate/{referenceNumber}";

    void addCandidate(CandidateRequestDTO candidateRequestDTO) throws HrmException;

    void deleteCandidate(String referenceNumber) throws HrmException;
}
