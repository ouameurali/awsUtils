package com.cooptalis.hrmanagement.service;

import com.cooptalis.hrmanagement.entities.Candidate;
import com.cooptalis.hrmanagement.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class CandidateCheck {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateCheck(CandidateRepository candidateRepository) {
        this.candidateRepository = requireNonNull(candidateRepository);
    }

    public Optional<Candidate> checkCandidateExist(String referenceCandidate) {
        return candidateRepository.findByReferenceCandidate(referenceCandidate);
    }
}
