package org.enaaskillsapp.authservice.mapping;


import org.enaaskillsapp.authservice.dto.mapping.AuthUserDTO;
import org.enaaskillsapp.authservice.model.Coach;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface CoachMapper {

    Coach toEntity( AuthUserDTO authUserDTO );
    AuthUserDTO toDTO(Coach coach);

}
