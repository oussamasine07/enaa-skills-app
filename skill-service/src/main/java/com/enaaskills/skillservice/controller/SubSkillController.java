package com.enaaskills.skillservice.controller;



import com.enaaskills.skillservice.dto.validationDTO.ValidateSubSkillDTO;
import com.enaaskills.skillservice.exception.NotFoundException;
import com.enaaskills.skillservice.model.Skill;
import com.enaaskills.skillservice.model.SubSkill;
import com.enaaskills.skillservice.repository.SkillRepository;
import com.enaaskills.skillservice.service.SubSkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sub-skill")
public class SubSkillController {

   private final SubSkillService subSkillService;
    private final SkillRepository skillRepository;

    public SubSkillController (
           final SubSkillService subSkillService,
           SkillRepository skillRepository) {
       this.subSkillService = subSkillService;
        this.skillRepository = skillRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllSubSkills () {

        return subSkillService.listSubSkills();
    }

    @PostMapping
    public ResponseEntity<?> createSubSkill (@Valid @RequestBody ValidateSubSkillDTO validateSubSkillDTO) {
        Skill skill = skillRepository
                .findById(validateSubSkillDTO.skill_id())
                .orElseThrow(() -> new NotFoundException("this skill is not found"));

        SubSkill newSubSkill = new SubSkill();
        newSubSkill.setName(validateSubSkillDTO.name());
        newSubSkill.setSkill(skill);

        return subSkillService.createSubSkill( newSubSkill );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubSkill (@Valid @RequestBody ValidateSubSkillDTO validateSubSkillDTO, @PathVariable Long id) {

        Skill skill = skillRepository
                .findById(validateSubSkillDTO.skill_id())
                .orElseThrow(() -> new NotFoundException("this skill is not found"));

        SubSkill newSubSkill = new SubSkill();
        newSubSkill.setName(validateSubSkillDTO.name());
        newSubSkill.setSkill(skill);

        return subSkillService.updateSubSkill( newSubSkill, id );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubSkill ( @PathVariable Long id ) {
        return subSkillService.deleteSubSkill( id );
    }

}










