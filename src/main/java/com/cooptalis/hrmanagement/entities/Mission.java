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
@Table(name = "mission")
public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMission;

    @Column
    private String missionName;

    @Column
    private String companyName;

    @Column
    private String location;


    // uni-directional one-to-many association to Candidate , the mission class is slave one
    @OneToMany(mappedBy = "mission")
    private List<Candidate> candidates;

    @CreationTimestamp
    @Column(name = "created", nullable = true, updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated", nullable = true, insertable = false)
    private LocalDate updatedDate;
}
