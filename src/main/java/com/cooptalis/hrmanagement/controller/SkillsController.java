package com.cooptalis.hrmanagement.controller;

import com.cooptalis.hrmanagement.api.SkillsApi;
import com.cooptalis.hrmanagement.entities.Skills;
import com.cooptalis.hrmanagement.hrexception.HrmException;
import com.cooptalis.hrmanagement.service.SkillsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

@RestController
@Slf4j
public class SkillsController implements SkillsApi {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = requireNonNull(skillsService);
    }

    @GetMapping(SKILLS)
    @Override
    public Skills getSkills(@PathVariable String skillsName) throws HrmException {
        return skillsService.getSkills(skillsName);
    }

    @PostMapping(SKILLS)
    @Override
    public void addSkills(@PathVariable String skillsName) {
        skillsService.addSkills(skillsName);
    }
}
