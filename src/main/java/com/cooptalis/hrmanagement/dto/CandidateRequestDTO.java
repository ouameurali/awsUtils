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
    private String firstName;
    @NotNull(message = "lastName is mandatory")
    private String lastName;
    private Integer age;
    private String nationality;
    @NotNull(message = "referenceNumber is mandatory")
    private String referenceNumber;
    private List<String> skillsName;
}
