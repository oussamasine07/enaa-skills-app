package com.enaaskills.validationservice.service;
import com.enaaskills.validationservice.dto.mapping.RenderingResponseDTO;
import com.enaaskills.validationservice.dto.validation.RenderingValidationDTO;
import com.enaaskills.validationservice.feignclient.BriefInterface;
import com.enaaskills.validationservice.model.Rendering;
import com.enaaskills.validationservice.model.RenderingLink;
import com.enaaskills.validationservice.repository.RenderingLinkRepository;
import com.enaaskills.validationservice.repository.RenderingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class RenderingService {

    private final RenderingRepository renderingRepository;
    private final RenderingLinkRepository renderingLinkRepository;
    private final BriefInterface briefInterface;

    public RenderingService (
            final RenderingRepository renderingRepository,
            final RenderingLinkRepository renderingLinkRepository,
            final BriefInterface briefInterface
    ) {
        this.renderingRepository = renderingRepository;
        this.renderingLinkRepository = renderingLinkRepository;
        this.briefInterface = briefInterface;
    }

    public ResponseEntity<?> createRendering (RenderingValidationDTO renderingDTO) {

        // get brief id
        ResponseEntity res = briefInterface.getBriefId( renderingDTO.brief_id() );
        Long briefId = ((Number) res.getBody()).longValue();

        // create a new instance of rendering
        Rendering rendering = new Rendering();

        rendering.setBriefId(briefId);
        rendering.setMessage( renderingDTO.message() );

        List<String> links = renderingDTO.links();

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

    // get rendering
    public ResponseEntity<?> getRendering (Long renderingId) {

        // get rendering
        Rendering rendering = renderingRepository.findById( renderingId )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Rendering not found" ) );


        // 2. Get associated links
        List<RenderingLink> links = renderingLinkRepository.findByRendering_Id(renderingId);
        List<String> linkList = links.stream().map(RenderingLink::getLink).toList();

        // get brief
        ResponseEntity<?> res = briefInterface.getBriefById( rendering.getBriefId() );
        Object briefData = res.getBody();

        RenderingResponseDTO renderingResponseDTO = new RenderingResponseDTO(
                rendering.getId(),
                rendering.getMessage(),
                linkList,
                briefData
        );

        return new ResponseEntity<>(renderingResponseDTO, HttpStatus.OK);

    }


}



































