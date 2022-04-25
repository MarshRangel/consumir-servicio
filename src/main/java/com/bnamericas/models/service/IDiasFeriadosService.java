package com.bnamericas.models.service;

import java.util.List;

import com.bnamericas.models.entity.DiasFeriados;

public interface IDiasFeriadosService {

	public List<DiasFeriados> findAll();
	public DiasFeriados findById(Long id);
}
