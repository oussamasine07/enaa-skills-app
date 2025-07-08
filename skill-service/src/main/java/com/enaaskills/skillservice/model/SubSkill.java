package com.enaaskills.skillservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_skills")
public class SubSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_valid", columnDefinition = "boolean default false")
    private Boolean isValid;

    @ManyToOne
    private Skill skill;

    public SubSkill () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
