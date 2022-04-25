package com.bnamericas.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnamericas.models.dao.DiasFeriadosDAO;
import com.bnamericas.models.entity.DiasFeriados;

@Service
public class DiasFeriadosServiceImpl implements IDiasFeriadosService{

	@Autowired
	private DiasFeriadosDAO diasFeriadosDAO;
	
	@Override
	public List<DiasFeriados> findAll() {
		return (List<DiasFeriados>) diasFeriadosDAO.findAll();
	}

	@Override
	public DiasFeriados findById(Long id) {
		return diasFeriadosDAO.findById(id).orElse(null);
	}
}
