package com.enaaskills.skillservice.controller;

import com.enaaskills.skillservice.dto.validationDTO.ValidateSkillDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "skill-service", url = "${skill-service.url}")
@RequestMapping("/api/v1/skill")
public interface SkillInterface {

    @GetMapping
    ResponseEntity<?> index ();

    @PostMapping
    ResponseEntity<?> newSkill (@Valid @RequestBody ValidateSkillDTO validateSkillDTO);

    @GetMapping("/{id}")
    ResponseEntity<?> getSkillById ( @PathVariable Long id );

    @GetMapping("/{id}")
    ResponseEntity<?> getSkillId ( @PathVariable Long id );

    @PutMapping("/{id}")
    ResponseEntity<?> updateSkill ( @RequestBody ValidateSkillDTO validateSkillDTO, @PathVariable Long id );

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteSkill ( @PathVariable Long id );

}
























