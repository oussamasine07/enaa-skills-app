package com.enaaskills.briefingservice.controller;

import com.enaaskills.briefingservice.dto.validationDTO.BriefDTO;
import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.repository.BriefRepository;
import com.enaaskills.briefingservice.service.BriefService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/briefs")
public class BriefController implements BriefInteface {

    @Autowired
    private BriefService briefService;
    @Autowired
    private BriefRepository briefRepository;

    @GetMapping
    public ResponseEntity<?> getAllBriefs () {
        return briefService.getAllBriefs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBriefById(@PathVariable Long id) {
        return briefService.getBriefById(id);
    }

    @GetMapping("/get-brief-by-id/{id}")
    public ResponseEntity<Long> getBriefId(@PathVariable Long id) {
        return briefService.getBriefId(id);
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrief(@PathVariable Long id, @Valid @RequestBody BriefDTO briefDTO) {
        Brief brief = new Brief();

        brief.setTitle(briefDTO.title());
        brief.setDescription(briefDTO.description());
        brief.setStartDate(briefDTO.startDate());
        brief.setEndDate(briefDTO.endDate());
        brief.setDuration(briefDTO.duration());
        brief.setEngagement(briefDTO.engagement());

        brief.setLaunchDate(LocalDate.now());

        return briefService.updateBrief(id, brief);
    }

    @DeleteMapping("/{id}")
    public void deleteBrief(@PathVariable Long id) {
        briefService.deleteBrief(id);
    }

}

















