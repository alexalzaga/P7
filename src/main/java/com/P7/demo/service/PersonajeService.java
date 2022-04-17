package com.P7.demo.service;

import com.P7.demo.model.PersonajeTable;
import com.P7.demo.service.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    //All data from Personajes Table
    List<PersonajeDTO> getPersonajes();

    //Borrar personajes
    void deletePersonaje(Long id);

    //Insertar Psicologos
    void addPersonaje(Long id, String name,String raza,String oficio);
}
