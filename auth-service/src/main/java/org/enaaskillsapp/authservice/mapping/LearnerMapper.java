package org.enaaskillsapp.authservice.mapping;


import org.enaaskillsapp.authservice.dto.mapping.AuthUserDTO;
import org.enaaskillsapp.authservice.model.Learner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LearnerMapper {

    Learner toEntity (AuthUserDTO authUserDTO);
    AuthUserDTO toDTO ( Learner learner );

}
