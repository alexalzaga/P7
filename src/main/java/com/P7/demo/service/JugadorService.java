package com.P7.demo.service;

import com.P7.demo.model.JugadorTable;
import com.P7.demo.service.dto.JugadorDTO;

import java.util.List;

public interface JugadorService {

    //All data from Jugadores Table
    List<JugadorDTO> getJugadores();

    //Jugadores con Personaje (JOIN EXAMPLE)
    List<JugadorDTO> getJugadoresConPersonaje();

    //Jugadores sin Personaje
    List<JugadorDTO> getJugadoresSinPersonaje();

    //Borrar Jugador
    void deleteJugador(Long id);

    //Actualizar Jugador
    void updateJugador(Long id, JugadorDTO jugador);
}