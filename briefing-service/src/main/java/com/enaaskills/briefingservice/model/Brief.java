package com.enaaskills.briefingservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "briefs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "launch_date", nullable = false)
    private LocalDate launchDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column( name = "duration", nullable = false)
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private Engagement engagement;

    @OneToMany(mappedBy = "brief")
    private List<BriefSkill> briefSkills;

//    @ElementCollection
//    private List<String> liverables;

//    @ElementCollection
//    private List<String> resources;
//

}

