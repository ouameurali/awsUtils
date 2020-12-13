package com.cooptalis.hrmanagement.service;

import com.cooptalis.hrmanagement.dto.CandidateRequestDTO;
import com.cooptalis.hrmanagement.entities.Candidate;
import com.cooptalis.hrmanagement.entities.Skills;
import com.cooptalis.hrmanagement.hrexception.HrmException;
import com.cooptalis.hrmanagement.repository.CandidateRepository;
import com.cooptalis.hrmanagement.repository.SkillsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final SkillsService skillsService;
    private final SkillsRepository skillsRepository;
    private final CandidateCheck candidateCheck;

    public CandidateService(CandidateRepository candidateRepository, SkillsService skillsService, SkillsRepository skillsRepository, CandidateCheck candidateCheck) {
        this.candidateRepository = requireNonNull(candidateRepository);
        this.skillsService = requireNonNull(skillsService);
        this.skillsRepository = requireNonNull(skillsRepository);
        this.candidateCheck = requireNonNull(candidateCheck);
    }

    @Transactional
    public void addCandidate(CandidateRequestDTO candidateRequestDTO) throws HrmException {

        log.info("check if the candidate already existe : {}", candidateRequestDTO.getReferenceNumber());

        Optional<Candidate> candidate = candidateCheck.checkCandidateExist(candidateRequestDTO.getReferenceNumber());
        if (candidate.isPresent()) {
            log.error("Candidate Already Existe");
            throw new HrmException("Candidate Already Existe");
        }

        List<Skills> skillsList = new ArrayList<>();
        for (String skillName : candidateRequestDTO.getSkillsName()) {
            Skills skills = skillsService.getSkills(skillName);
            skillsList.add(skills);
        }
        Candidate newCandidate = Candidate.builder()
                .firstName(candidateRequestDTO.getFirstName())
                .lastName(candidateRequestDTO.getLastName())
                .age(candidateRequestDTO.getAge())
                .nationality(candidateRequestDTO.getNationality())
                .referenceCandidate(candidateRequestDTO.getReferenceNumber())
                .skills(skillsList)
                .build();
        candidateRepository.save(newCandidate);
    }

    public void removeCandidate(String referenceNumber) throws HrmException {
        Optional<Candidate> candidate = candidateCheck.checkCandidateExist(referenceNumber);
        if (!candidate.isPresent()) {
            throw new HrmException("Candidate to be removed not found");
        }
        candidateRepository.delete(candidate.get());
    }
}
