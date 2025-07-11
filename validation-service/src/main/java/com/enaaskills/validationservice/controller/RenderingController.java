package com.enaaskills.validationservice.controller;

import com.enaaskills.validationservice.dto.validation.RenderingValidationDTO;
import com.enaaskills.validationservice.model.Rendering;
import com.enaaskills.validationservice.service.RenderingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rendering")
public class RenderingController {

    private final RenderingService renderingService;

    public RenderingController (
            final RenderingService renderingService
    ) {
        this.renderingService = renderingService;
    }

    @PostMapping
    public ResponseEntity<?> makeNewRendering (
            @Valid @RequestBody RenderingValidationDTO renderingValidationDTO
    ) {
        Rendering newRendering = new Rendering();

        newRendering.setBriefId(renderingValidationDTO.brief_id());
        newRendering.setMessage(renderingValidationDTO.message());

        return renderingService.createRendering(newRendering, renderingValidationDTO.links());

    }

}























