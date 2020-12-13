package com.cooptalis.hrmanagement.api;

import com.cooptalis.hrmanagement.entities.Skills;
import com.cooptalis.hrmanagement.hrexception.HrmException;

public interface SkillsApi {

    String SKILLS = "api/skills/{skillsName}";

    Skills getSkills(String skillsName) throws HrmException;

    void addSkills(String skillsName);

}
