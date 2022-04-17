package com.P7.demo.controller;

import com.P7.demo.model.PersonajeTable;
import com.P7.demo.service.PersonajeService;
import com.P7.demo.service.dto.PersonajeDTO;
import com.P7.demo.service.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getAllPersonajes(){
        List<PersonajeDTO> personajes = new ArrayList<PersonajeDTO>();
        personajes = personajeService.getPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/personajes/{id}")
    public ResponseEntity<PersonajeDTO> getPersonajeById(@PathVariable("id") long id){
        PersonajeDTO personajeEncontrado = null;
        List<PersonajeDTO> personajes = new ArrayList<PersonajeDTO>();
        personajes = personajeService.getPersonajes();
        for (PersonajeDTO personaje : personajes){
            if (personaje.getId() == id)
                personajeEncontrado = personaje;
        }
        return ResponseEntity.ok().body(personajeEncontrado);
    }

    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<PersonajeDTO> deletePersonajeById(@PathVariable("id") long id){
        personajeService.deletePersonaje(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/personajes")
    public ResponseEntity<JugadorDTO> addPersonaje(@RequestBody Long id, String name, String raza, String oficio){
        personajeService.addPersonaje(id,name,raza,oficio);
        return ResponseEntity.noContent().build();
    }
}