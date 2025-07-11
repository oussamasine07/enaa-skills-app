package com.enaaskills.validationservice.service;
import com.enaaskills.validationservice.model.Rendering;
import com.enaaskills.validationservice.model.RenderingLink;
import com.enaaskills.validationservice.repository.RenderingLinkRepository;
import com.enaaskills.validationservice.repository.RenderingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RenderingService {

    private final RenderingRepository renderingRepository;
    private final RenderingLinkRepository renderingLinkRepository;

    public RenderingService (
            final RenderingRepository renderingRepository,
            final RenderingLinkRepository renderingLinkRepository
    ) {
        this.renderingRepository = renderingRepository;
        this.renderingLinkRepository = renderingLinkRepository;
    }

    public ResponseEntity<?> createRendering (Rendering rendering, List<String> links) {

        Rendering createdRendering = renderingRepository.save(rendering);
        List<RenderingLink> renderingLinks = new ArrayList<>();

        links.forEach( link -> {
            RenderingLink newRenderingLink = new RenderingLink();
            newRenderingLink.setLink(link);
            newRenderingLink.setRendering( createdRendering );
            RenderingLink createdRenderingLink = renderingLinkRepository.save( newRenderingLink );

            renderingLinks.add( createdRenderingLink );
        });

        createdRendering.setRenderingLinks( renderingLinks );

        return new ResponseEntity<>(renderingRepository.save( createdRendering ), HttpStatus.OK);
    }

}



































