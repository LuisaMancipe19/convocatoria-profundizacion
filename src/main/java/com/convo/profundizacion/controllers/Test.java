package com.convo.profundizacion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
