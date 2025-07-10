package com.enaaskills.briefingservice.controller;

import com.enaaskills.briefingservice.dto.validationDTO.ValidationBriefSkillDTO;
import com.enaaskills.briefingservice.service.BriefSkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BriefSkillController implements BriefSkillInterface {

    private final BriefSkillService briefSkillService;

    public BriefSkillController (
            final BriefSkillService briefSkillService
    ) {
        this.briefSkillService = briefSkillService;
    }

    @PostMapping("/assign-skill/{briefId}")
    public ResponseEntity<?> assignSkillToBrief(
            @PathVariable Long briefId,
            @Valid @RequestBody ValidationBriefSkillDTO validationBriefSkillDTO
    ) {
        return briefSkillService.assignSkillToBrief(briefId, validationBriefSkillDTO.skill_id());
    };

}
