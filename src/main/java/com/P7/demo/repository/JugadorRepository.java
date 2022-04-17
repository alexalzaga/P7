package com.P7.demo.repository;

import com.P7.demo.model.JugadorTable;
import org.springframework.data.repository.CrudRepository;

public interface JugadorRepository extends CrudRepository<JugadorTable,Long> {}