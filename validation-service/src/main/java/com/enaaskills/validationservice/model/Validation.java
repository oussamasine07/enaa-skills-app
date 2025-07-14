package com.enaaskills.validationservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "validations")
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "validation_rate")
    private Integer validationRate;

    @OneToOne
    private Rendering rendering;

    @ElementCollection
    @CollectionTable(name = "validation_skills", joinColumns = @JoinColumn(name = "validation_id"))
    @Column(name = "skill_id")
    private List<Integer> skillsIds;

}
