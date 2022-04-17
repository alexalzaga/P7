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
@Table("PERSONAJES")
public class PersonajeTable {
    private @Column("ID") @Id Long id;
    private @Column("NAME") String name;
    private @Column("RAZA") String raza;
    private @Column("OFICIO") String oficio;
}