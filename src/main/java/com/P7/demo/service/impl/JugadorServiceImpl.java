package com.P7.demo.service.impl;

import com.P7.demo.service.JugadorService;
import com.P7.demo.model.JugadorTable;
import com.P7.demo.repository.JugadorRepository;
import com.P7.demo.service.JugadorService;
import com.P7.demo.service.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JugadorRepository usuarioRepository;

    @Override
    public List<JugadorDTO> getJugadores() {
        return StreamSupport.stream(usuarioRepository.findAll().spliterator(),false)
                .map(obj -> new JugadorDTO(
                        obj.getId(),
                        obj.getUsername(),
                        obj.getPassword(),
                        obj.getIdPersonaje()))
                .toList();
    }

    @Override
    public List<JugadorDTO> getJugadoresConPersonaje() {

        String query=
                """
                SELECT J.ID, J.USERNAME, J.PASSWORD, P.NAME, P.OFICIO
                FROM JUGADORES J
                JOIN PERSONAJES P
                ON J.ID_PERSONAJE=P.ID;
                """;

        List<JugadorDTO> usuariosList = jdbcTemplate.query(
                query,
                (rs, rowNum) ->
                        new JugadorDTO(
                                rs.getLong("ID"),
                                rs.getString("USERNAME"),
                                rs.getString("PASSWORD"),
                                rs.getLong("ID_PERSONAJE"))
        );

        return usuariosList;
    }

    @Override
    public List<JugadorDTO> getJugadoresSinPersonaje() {

        String query=
                """
                SELECT ID, USERNAME, PASSWORD, ID_PERSONAJE
                FROM JUGADORES
                WHERE ID_PERSONAJE=0;
                """;

        List<JugadorDTO> usuariosList = jdbcTemplate.query(
                query,
                (rs, rowNum) ->
                        new JugadorDTO(
                                rs.getLong("ID"),
                                rs.getString("USER_NAME"),
                                rs.getString("USER_PWD"),
                                rs.getLong("ID_PSIC"))
        );

        return usuariosList;
    }

    @Override
    public void deleteJugador(Long id) {
        jdbcTemplate.execute("DELETE FROM JUGADORES WHERE ID='"+id+"'");
    }


    @Override
    public void updateJugador(Long id, JugadorDTO jugador) {
        String username = jugador.getUsername();
        String password = jugador.getPassword();
        Long id_p = jugador.getIdPersonaje();
        jdbcTemplate.execute("UPDATE JUGADORES SET USERNAME ='"+username+"',PASSWORD="+password+",ID_PERSONAJE='"+id_p+"' WHERE ID="+id);
    }
}