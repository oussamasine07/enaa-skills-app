package com.enaaskills.briefingservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "briefs")
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

    @JsonIgnore
    @OneToMany(mappedBy = "brief")
    private List<BriefSkill> briefSkills;

//    @ElementCollection
//    private List<String> liverables;

//    @ElementCollection
//    private List<String> resources;
//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Engagement getEngagement() {
        return engagement;
    }

    public void setEngagement(Engagement engagement) {
        this.engagement = engagement;
    }

    public List<BriefSkill> getBriefSkills() {
        return briefSkills;
    }

    public void setBriefSkills(List<BriefSkill> briefSkills) {
        this.briefSkills = briefSkills;
    }
}

