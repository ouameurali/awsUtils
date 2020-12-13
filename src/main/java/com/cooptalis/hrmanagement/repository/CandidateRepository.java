package com.cooptalis.hrmanagement.repository;

import com.cooptalis.hrmanagement.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByReferenceCandidate(String referenceCandidate);
}
