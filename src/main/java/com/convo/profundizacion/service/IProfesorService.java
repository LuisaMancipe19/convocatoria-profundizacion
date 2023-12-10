package com.convo.profundizacion.service;

import com.convo.profundizacion.dto.ProfesorDto;
import com.convo.profundizacion.exception.GenericException;

import java.util.List;
import java.util.Optional;

public interface IProfesorService {
    ProfesorDto save(ProfesorDto profesorDto) throws GenericException;

    List<ProfesorDto> getALL();

    ProfesorDto findByNumeroDocumento(String numeroDocumento);

    Optional<ProfesorDto> findById(Long id);

    ProfesorDto updateProfesor(Long id, ProfesorDto profesorDto) throws GenericException;

    Optional<ProfesorDto> deleteProfesor(Long id) throws GenericException;
}
