package com.bnamericas.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.bnamericas.models.entity.DiasFeriados;

@Component
public interface DiasFeriadosDAO extends CrudRepository<DiasFeriados, Long>{

}
