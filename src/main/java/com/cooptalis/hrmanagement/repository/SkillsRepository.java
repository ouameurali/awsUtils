package com.cooptalis.hrmanagement.repository;

import com.cooptalis.hrmanagement.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillsRepository extends JpaRepository<Skills, Long> {

   Optional<Skills> findByskillName(String skillName);
}
