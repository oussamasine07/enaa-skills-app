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

}
