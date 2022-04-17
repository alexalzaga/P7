package com.P7.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDTO {
    private Long id;
    private String username;
    private String password;
    private Long idPersonaje;
}