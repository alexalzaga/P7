package com.P7.demo.service.impl;

import com.P7.demo.model.PersonajeTable;
import com.P7.demo.repository.PersonajeRepository;
import com.P7.demo.service.PersonajeService;
import com.P7.demo.service.dto.JugadorDTO;
import com.P7.demo.service.dto.PersonajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getPersonajes() {
        return StreamSupport.stream(personajeRepository.findAll().spliterator(),false)
                .map(obj -> new PersonajeDTO(
                        obj.getId(),
                        obj.getName(),
                        obj.getRaza(),
                        obj.getOficio()))
                .toList();
    }

    @Override
    public void deletePersonaje(Long id) {
        jdbcTemplate.execute("DELETE FROM PERSONAJES WHERE ID='"+id+"'");
    }


    @Override
    public void addPersonaje(Long id, String name,String raza,String oficio) {
        jdbcTemplate.execute("INSERT INTO PERSONAJES (ID,NAME,RAZA,OFICIO) VALUES ("+id+",'"+name+"','"+raza+"','"+oficio+"')");
    }
}