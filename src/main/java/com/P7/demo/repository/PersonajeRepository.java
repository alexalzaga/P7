package com.P7.demo.repository;

import com.P7.demo.model.PersonajeTable;
import org.springframework.data.repository.CrudRepository;

public interface PersonajeRepository extends CrudRepository<PersonajeTable,Long> {}