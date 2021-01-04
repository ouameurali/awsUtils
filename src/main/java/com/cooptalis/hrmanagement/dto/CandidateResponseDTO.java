package com.cooptalis.hrmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponseDTO {
    String firstName;
    String lastName;
    Integer age;
    String nationality;
    List<String> skillsName;
}
