package com.convo.profundizacion.controller;

import com.convo.profundizacion.dto.ErrorResponse;
import com.convo.profundizacion.dto.ProfesorDto;
import com.convo.profundizacion.exception.GenericException;
import com.convo.profundizacion.service.impl.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/guardar")
    @Operation(summary = "Endpoint para crear un profesor", description = "Permite guardar un profesor en la base de datos")
    public ResponseEntity<Object> guardarProfesor(@RequestBody ProfesorDto profesorDto) {

        ProfesorDto respuesta;
        try {
            respuesta = profesorService.save(profesorDto);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/buscarTodos")
    @Operation(summary = "Endpoint para buscar un profesor", description = "Permite buscar un profesor en la base de datos")
    public ResponseEntity<List<ProfesorDto>> findAll() {
        List<ProfesorDto> driverDtos = profesorService.getALL();
        return new ResponseEntity<>(driverDtos, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Endpoint para actualizar un profesor", description = "Permite actualizar un profesor en la base de datos")
    public ResponseEntity<Object> actualizarProfesor(@RequestParam(name = "id") Long id,
                                                     @RequestBody ProfesorDto profesorDto) {

        ProfesorDto respuesta;
        try {
            respuesta = profesorService.updateProfesor(id, profesorDto);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    @Operation(summary = "Endpoint para eliminar un profesor", description = "Permite eliminar un profesor en la base de datos")
    public ResponseEntity<Object> actualizarProfesor(@RequestParam(name = "id") Long id) {

        Optional<ProfesorDto> respuesta;
        try {
            respuesta = profesorService.deleteProfesor(id);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
