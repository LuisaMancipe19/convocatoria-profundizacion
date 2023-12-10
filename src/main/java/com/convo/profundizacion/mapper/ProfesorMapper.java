package com.convo.profundizacion.mapper;

import com.convo.profundizacion.dto.ProfesorDto;
import com.convo.profundizacion.entity.ProfesorEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    ProfesorDto toProfesorDto(ProfesorEntity profesorEntity);

    @InheritInverseConfiguration
    ProfesorEntity toProfesorEntity(ProfesorDto profesorDto);

    List<ProfesorDto> toListDto(List<ProfesorEntity> profesorEntity);

    @InheritInverseConfiguration
    List<ProfesorEntity> toListEntity(List<ProfesorDto> profesorDto);

    @AfterMapping
    default Optional<ProfesorDto> mapOptional(Optional<ProfesorEntity> source) {
        return source.map(this::toProfesorDto);
    }
}
