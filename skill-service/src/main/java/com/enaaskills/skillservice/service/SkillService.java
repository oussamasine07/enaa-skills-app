package com.enaaskills.skillservice.service;

import com.enaaskills.skillservice.dto.mappingDTO.MappedSkillDTO;
import com.enaaskills.skillservice.exception.NotFoundException;
import com.enaaskills.skillservice.mapper.SkillMapper;
import com.enaaskills.skillservice.model.Skill;
import com.enaaskills.skillservice.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillService (
            final SkillRepository skillRepository,
            final SkillMapper skillMapper
    ) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    public ResponseEntity<?> listSkills () {
        List<MappedSkillDTO> skills = skillRepository
                .findSkillsWithSubSkills()
                .stream()
                .map(skillMapper::toDTO)
                .collect(Collectors.toList());

       // List<Skill> skills = skillRepository.findSkillsWithSubSkills();

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    public ResponseEntity<?> getSkillById( Long skillId ) {
        Skill skill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("this skill is not found"));
        MappedSkillDTO mappedSkill = skillMapper.toDTO( skill );

        return new ResponseEntity<>(mappedSkill, HttpStatus.OK);
    }

    public ResponseEntity<Long> getSkillId (Long id) {
        Skill skill = skillRepository.findById( id )
                .orElseThrow(() -> new NotFoundException("this skill is not found"));

        return new ResponseEntity<>(skill.getId(), HttpStatus.OK);
    }

    public ResponseEntity<?> createSkill ( Skill skill ) {
        return new ResponseEntity<>(skillRepository.save( skill ), HttpStatus.OK);
    }

    public ResponseEntity<?> updateSkill (Skill skill, Long skillId ) {
        Skill updatedSkill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("you can't update an unfound skill"));

        updatedSkill.setName( skill.getName() );

        return new ResponseEntity<>(skillRepository.save( updatedSkill ), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteSkill ( Long skillId ) {
        Skill deletedSkill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("you can't delete an unfound skill"));

        Map<String, String> success = new HashMap<>();
        success.put("status", "success");
        success.put("message", "skill: " + deletedSkill.getName() + " was deleted Successfully");

        skillRepository.deleteById( skillId );

        return new ResponseEntity<>( success, HttpStatus.OK );

    }

}
