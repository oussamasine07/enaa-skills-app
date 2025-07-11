package com.enaaskills.briefingservice.controller;

import com.enaaskills.briefingservice.dto.validationDTO.ValidationBriefSkillDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "briefing-service", url = "${briefing-service.url}" )
@RequestMapping("/brief-skills")
public interface BriefSkillInterface {

    @PostMapping("/assign-skill/{briefId}")
    ResponseEntity<?> assignSkillToBrief(@PathVariable Long briefId, @Valid @RequestBody ValidationBriefSkillDTO validationBriefSkillDTO );

}
