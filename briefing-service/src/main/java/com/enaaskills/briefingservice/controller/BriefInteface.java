package com.enaaskills.briefingservice.controller;

import com.enaaskills.briefingservice.dto.validationDTO.BriefDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "briefing-service", url = "${briefing-service.url}")
@RequestMapping("/briefs")
public interface BriefInteface {

    @GetMapping
    ResponseEntity<?> getAllBriefs ();

    @GetMapping("/{id}")
    ResponseEntity<?> getBriefById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<?> addBrief(@Valid @RequestBody BriefDTO briefDTO);

    @PutMapping("/{id}")
    ResponseEntity<?> updateBrief(@PathVariable Long id, @Valid @RequestBody BriefDTO briefDTO);

    @DeleteMapping("/{id}")
    void deleteBrief(@PathVariable Long id);

}


















