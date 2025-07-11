package com.enaaskills.validationservice.controller;

import com.enaaskills.validationservice.dto.validation.RenderingValidationDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/v1/rendering")
public interface RenderingInterface {

    @PostMapping
    public ResponseEntity<?> makeNewRendering (
            @Valid @RequestBody RenderingValidationDTO renderingValidationDTO
    );

}
