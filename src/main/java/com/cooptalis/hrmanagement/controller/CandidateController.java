package com.cooptalis.hrmanagement.controller;

import com.cooptalis.hrmanagement.api.CandidateApi;
import com.cooptalis.hrmanagement.dto.CandidateRequestDTO;
import com.cooptalis.hrmanagement.hrexception.HrmException;
import com.cooptalis.hrmanagement.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.requireNonNull;

@RestController
@Slf4j
public class CandidateController implements CandidateApi {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = requireNonNull(candidateService);
    }

    @PostMapping(ADD_CANDIDATE)
    @Override
    public void addCandidate(@Valid @RequestBody CandidateRequestDTO candidateRequestDTO) throws HrmException {
        candidateService.addCandidate(candidateRequestDTO);
    }

    @DeleteMapping(DELETE_CANDIDATE)
    @Override
    public void deleteCandidate(@PathVariable String referenceNumber) throws HrmException {
        candidateService.removeCandidate(referenceNumber);
    }
}
