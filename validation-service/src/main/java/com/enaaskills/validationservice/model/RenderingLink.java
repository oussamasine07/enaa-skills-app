package com.enaaskills.validationservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rendering_links")
public class RenderingLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link")
    private String link;

    @ManyToOne
    private Rendering rendering;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Rendering getRendering() {
        return rendering;
    }

    public void setRendering(Rendering rendering) {
        this.rendering = rendering;
    }
}
