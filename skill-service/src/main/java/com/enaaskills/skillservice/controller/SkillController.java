package com.enaaskills.skillservice.controller;




import com.enaaskills.skillservice.dto.validationDTO.ValidateSkillDTO;
import com.enaaskills.skillservice.model.Skill;
import com.enaaskills.skillservice.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/skill")
public class SkillController implements SkillInterface {

    private final SkillService skillService;

    public SkillController (
            final SkillService skillService
    ) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<?> index () {
        return skillService.listSkills();
    }

    @GetMapping("/skill-id/{id}")
    public ResponseEntity<Long> getSkillId ( @PathVariable Long id ){
        return skillService.getSkillId( id );
    };

    @PostMapping
    public ResponseEntity<?> newSkill (@Valid @RequestBody ValidateSkillDTO validateSkillDTO) {
        Skill newSkill = new Skill();
        newSkill.setName(validateSkillDTO.name());

        return skillService.createSkill( newSkill );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSkillById ( @PathVariable Long id ) {
        return skillService.getSkillById( id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSkill ( @RequestBody ValidateSkillDTO validateSkillDTO, @PathVariable Long id ) {

        Skill skill = new Skill();
        skill.setName( validateSkillDTO.name() );
        return skillService.updateSkill( skill, id );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill ( @PathVariable Long id ) {
        return skillService.deleteSkill( id );
    }

}



















