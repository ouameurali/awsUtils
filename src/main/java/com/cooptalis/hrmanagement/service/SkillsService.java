package com.cooptalis.hrmanagement.service;

import com.cooptalis.hrmanagement.entities.Skills;
import com.cooptalis.hrmanagement.hrexception.HrmException;
import com.cooptalis.hrmanagement.repository.SkillsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = requireNonNull(skillsRepository);
    }

    public Skills getSkills(String skillsName) throws HrmException {
        return skillsRepository.findByskillName(skillsName).orElseThrow(() -> new HrmException("skills not found !"));
    }

    @Transactional
    public void addSkills(String skillsName) {
        Skills skills = Skills.builder().skillName(skillsName).build();
        skillsRepository.save(skills);
    }
}
