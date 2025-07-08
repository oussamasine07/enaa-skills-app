package com.enaaskills.skillservice.mapper;


import com.enaaskills.skillservice.dto.mappingDTO.MappedSubSkillDTO;
import com.enaaskills.skillservice.model.SubSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubSkillMapper {
    SubSkill toEntity(MappedSubSkillDTO mappedSubSkillDTO);
    MappedSubSkillDTO toDTO( SubSkill subSkill );
}
