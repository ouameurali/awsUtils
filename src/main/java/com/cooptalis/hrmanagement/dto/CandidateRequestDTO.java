package com.cooptalis.hrmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRequestDTO {
    @NotNull(message = "firstName is mandatory")
    String firstName;
    @NotNull(message = "lastName is mandatory")
    String lastName;
    Integer age;
    String nationality;
    @NotNull(message = "referenceNumber is mandatory")
    String referenceNumber;
    List<String> skillsName;
}
