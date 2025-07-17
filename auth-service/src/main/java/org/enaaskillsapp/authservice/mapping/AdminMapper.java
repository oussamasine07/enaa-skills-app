package org.enaaskillsapp.authservice.mapping;


import org.enaaskillsapp.authservice.dto.mapping.AuthUserDTO;
import org.enaaskillsapp.authservice.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    Admin toEntity(AuthUserDTO authUserDTO);
    AuthUserDTO toDTO( Admin admin );

}
