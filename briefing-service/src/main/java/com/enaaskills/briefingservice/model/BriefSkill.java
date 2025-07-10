package com.enaaskills.briefingservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brief_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BriefSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brief brief;

    private Long skillsId;
}
