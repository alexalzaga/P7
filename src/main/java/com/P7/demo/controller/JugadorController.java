package com.P7.demo.controller;

import com.P7.demo.model.JugadorTable;
import com.P7.demo.repository.JugadorRepository;
import com.P7.demo.service.JugadorService;
import com.P7.demo.service.dto.PersonajeDTO;
import com.P7.demo.service.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/jugadores")
    public ResponseEntity<List<JugadorDTO>> getAllJugadores(){
        List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
        jugadores = jugadorService.getJugadores();
        return ResponseEntity.ok().body(jugadores);
    }

    @GetMapping("/jugadores/{id}")
    public ResponseEntity<JugadorDTO> getJugadorById(@PathVariable("id") long id){
        JugadorDTO jugadorEncontrado = null;
        List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
        jugadores = jugadorService.getJugadores();
        for (JugadorDTO jugador : jugadores){
            if (jugador.getId() == id)
                jugadorEncontrado = jugador;
        }
        return ResponseEntity.ok().body(jugadorEncontrado);
    }

    @GetMapping("/jugadores/conpersonaje")
    public ResponseEntity<List<JugadorDTO>> getAllJugadoresConPersonaje(){
        List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
        jugadores = jugadorService.getJugadoresConPersonaje();
        return ResponseEntity.ok().body(jugadores);
    }

    @GetMapping("/jugadores/conpersonaje/{idPersonaje}")
    public ResponseEntity<JugadorDTO> getAllJugadoresConPersonajeById(@PathVariable("idPersonaje") long idPersonaje){
        List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
        JugadorDTO jugadorEncontrado = null;
        jugadores = jugadorService.getJugadoresConPersonaje();
        for (JugadorDTO jugador : jugadores){
            if (jugador.getIdPersonaje() == idPersonaje){
                jugadorEncontrado = jugador;
            }
        }
        return ResponseEntity.ok().body(jugadorEncontrado);
    }

    @GetMapping("/jugadores/sinpersonaje")
    public ResponseEntity<List<JugadorDTO>> getAllJugadoresSinPersonaje(){
        List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
        jugadores = jugadorService.getJugadoresSinPersonaje();
        return ResponseEntity.ok().body(jugadores);
    }

    @DeleteMapping("/jugadores/{id}")
    public ResponseEntity<JugadorDTO> deleteJugadorById(@PathVariable("id") long id){
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jugadores/{id}")
    public ResponseEntity<JugadorDTO> updateJugador(@PathVariable Long id, @RequestBody JugadorDTO jugador){
        jugadorService.updateJugador(id,jugador);
        return ResponseEntity.noContent().build();
    }
}