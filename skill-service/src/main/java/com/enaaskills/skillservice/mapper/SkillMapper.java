package com.enaaskills.skillservice.mapper;


import com.enaaskills.skillservice.dto.mappingDTO.MappedSkillDTO;
import com.enaaskills.skillservice.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(MappedSkillDTO mappedSkillDTO);
    MappedSkillDTO toDTO( Skill skill );
}
