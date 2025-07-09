package com.enaaskills.briefingservice.controller;

import com.enaaskills.briefingservice.dto.validationDTO.BriefDTO;
import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.service.BriefService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/briefs")
public class BriefController {

    @Autowired
    private BriefService briefService;

    @GetMapping
    public ResponseEntity<?> getAllBriefs () {
        return briefService.getAllBriefs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBriefById(@PathVariable Long id) {
        return briefService.getBriefById(id);
    }

    @PostMapping
    public ResponseEntity<?> addBrief(@Valid @RequestBody BriefDTO briefDTO) {

        Brief brief = new Brief();

        brief.setTitle(briefDTO.title());
        brief.setDescription(briefDTO.description());
        brief.setStartDate(briefDTO.startDate());
        brief.setEndDate(briefDTO.endDate());
        brief.setDuration(briefDTO.duration());
        brief.setEngagement(briefDTO.engagement());

        LocalDate launchDate = LocalDate.now();
        brief.setLaunchDate(launchDate);

        return briefService.addBrief( brief );

    }
}
