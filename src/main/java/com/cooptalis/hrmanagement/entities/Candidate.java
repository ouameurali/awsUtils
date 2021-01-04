package com.cooptalis.hrmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "candidate")

public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String referenceCandidate;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private Integer age;

    @Column
    private String nationality;

    @Column
    private String email;

    @Column
    private String tel;

    @Column
    private String job;

    @Column
    private String level;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "candidate_skills",
            joinColumns = @JoinColumn(name = "referenceCandidate"),
            inverseJoinColumns = @JoinColumn(name = "idSkills"))
    private List<Skills> skills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_mission")
    private Mission mission;

    @CreationTimestamp
    @Column(name = "created", nullable = true, updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated", nullable = true, insertable = false)
    private LocalDate updatedDate;
}
