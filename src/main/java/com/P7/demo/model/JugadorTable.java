package com.P7.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("JUGADORES")
public class JugadorTable {
    private @Column("ID") @Id Long id;
    private @Column("USERNAME") String username;
    private @Column("PASSWORD") String password;
    private @Column("PERSONAJE_ID") Long idPersonaje;
}