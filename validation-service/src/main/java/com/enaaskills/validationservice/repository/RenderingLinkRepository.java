package com.enaaskills.validationservice.repository;

import com.enaaskills.validationservice.model.RenderingLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RenderingLinkRepository extends JpaRepository<RenderingLink, Long> {

    @Query(value = "select * from rendering_links where rendering_id = ?", nativeQuery = true)
    List<RenderingLink> findByRendering_Id(Long renderingId);

}
