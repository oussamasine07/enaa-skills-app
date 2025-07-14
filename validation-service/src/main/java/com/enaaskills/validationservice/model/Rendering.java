package com.enaaskills.validationservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "renderings")
public class Rendering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "learner_id")
    private Long learnerId;

    @Column(name = "brief_id")
    private Long briefId;

    @OneToMany(mappedBy = "rendering")
    private List<RenderingLink> renderingLinks;

    @OneToOne
    private Validation validation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }

    public Long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public List<RenderingLink> getRenderingLinks() {
        return renderingLinks;
    }

    public void setRenderingLinks(List<RenderingLink> renderingLinks) {
        this.renderingLinks = renderingLinks;
    }
}
