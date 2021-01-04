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
@Table(name = "skills")
public class Skills implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkills;

    @Column
    private String skillName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    private List<Candidate> candidates;

    @CreationTimestamp
    @Column(name = "created", nullable = true, updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated", nullable = true, insertable = false)
    private LocalDate updatedDate;


}
