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
public class RenderingController implements RenderingInterface {

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

        System.out.println(" testing new rendering");
        return renderingService.createRendering( renderingValidationDTO );

    }

}























