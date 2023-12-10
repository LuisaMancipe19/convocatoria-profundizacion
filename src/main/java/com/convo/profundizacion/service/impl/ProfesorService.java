package com.convo.profundizacion.service.impl;

import com.convo.profundizacion.dto.ProfesorDto;
import com.convo.profundizacion.entity.ProfesorEntity;
import com.convo.profundizacion.exception.GenericException;
import com.convo.profundizacion.mapper.ProfesorMapper;
import com.convo.profundizacion.repository.ProfesorRepository;
import com.convo.profundizacion.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements IProfesorService {

    @Autowired
    private ProfesorMapper profesorMapper;
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ProfesorDto save(ProfesorDto profesorDto) throws GenericException {

        ProfesorDto existeProfesor = findByNumeroDocumento(profesorDto.getNumeroDocumento());
        if (existeProfesor != null) {
            throw new GenericException("El número de documento ya se encuentra registrado.");
        }

        ProfesorDto guardarProfesor = profesorMapper.toProfesorDto(
                profesorRepository.save(profesorMapper.toProfesorEntity(profesorDto)));
        return guardarProfesor;
    }

    @Override
    public List<ProfesorDto> getALL() {
        List<ProfesorEntity> driverEntities = profesorRepository.findAll();
        return profesorMapper.toListDto(driverEntities);
    }

    @Override
    public ProfesorDto findByNumeroDocumento(String numeroDocumento) {
        ProfesorDto resultado = profesorMapper.toProfesorDto(
                profesorRepository.findByNumeroDocumento(numeroDocumento));
        return resultado;
    }

    @Override
    public Optional<ProfesorDto> findById(Long id) {
        Optional<ProfesorEntity> resultado = profesorRepository.findById(id);
        return profesorMapper.mapOptional(resultado);
    }

    @Override
    public ProfesorDto updateProfesor(Long id, ProfesorDto profesorDto) throws GenericException {
        Optional<ProfesorDto> existeProfesor = findById(id);
        if (existeProfesor == null) {
            throw new GenericException("No existen registros para el Id ingresado.");
        }

        ProfesorDto actualizar = new ProfesorDto();
        actualizar.setId(id);
        actualizar.setTipoDocumento(profesorDto.getTipoDocumento());
        actualizar.setNumeroDocumento(profesorDto.getNumeroDocumento());
        actualizar.setNombre(profesorDto.getNombre());
        actualizar.setSegundoNombre(profesorDto.getSegundoNombre());
        actualizar.setApellido(profesorDto.getApellido());
        actualizar.setSegundoApellido(profesorDto.getSegundoApellido());

        ProfesorDto guardar = save(actualizar);
        return guardar;
    }

    @Override
    public Optional<ProfesorDto> deleteProfesor(Long id) throws GenericException {
        Optional<ProfesorDto> existeProfesor = findById(id);
        if (existeProfesor == null) {
            throw new GenericException("No existen registros para el Id ingresado.");
        }

        profesorRepository.deleteById(id);
        return existeProfesor;
    }


}