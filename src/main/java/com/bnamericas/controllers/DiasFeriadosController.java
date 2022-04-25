package com.bnamericas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnamericas.models.dao.DiasFeriadosDAO;
import com.bnamericas.models.entity.DiasFeriados;
import com.bnamericas.models.service.IDiasFeriadosService;


@RestController
@RequestMapping("/feriados")
public class DiasFeriadosController {
	
	List<DiasFeriados> listaDiasFeriados;
	
	@Autowired
	private IDiasFeriadosService diasFeriadosService; 
	
	@GetMapping
	public List<DiasFeriados> getDiasFeriados() {
		return diasFeriadosService.findAll();
	}
	
	@GetMapping("/{id}")
	public DiasFeriados getDiaFeriadoDetalle(@PathVariable Long id) {
		return diasFeriadosService.findById(id);
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiasFeriados> createDiaFeriado(@RequestBody DiasFeriados diasFeriados) {
		DiasFeriados dia_feriado  = new DiasFeriados();
		dia_feriado.setDate(diasFeriados.getDate());
		dia_feriado.setTitle(diasFeriados.getTitle());
		dia_feriado.setExtra(diasFeriados.getExtra());
		return new ResponseEntity<DiasFeriados>(dia_feriado, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{id_df}", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiasFeriados> updateDiaFeriado(@PathVariable String id_df, @RequestBody DiasFeriados diasFeriados) {
		DiasFeriados dia_feriado  = null;
		int pos = 0;
		int aux = 0;
		for (DiasFeriados diaFeriado : listaDiasFeriados) {
			if (diaFeriado.getId().equals(id_df)) {
				dia_feriado=diaFeriado;
				aux=pos;
			}
			pos++;
		}
		
		dia_feriado.setDate(diasFeriados.getDate());
		dia_feriado.setTitle(diasFeriados.getTitle());
		dia_feriado.setExtra(diasFeriados.getExtra());
		
		listaDiasFeriados.remove(aux);
		listaDiasFeriados.add(aux, dia_feriado);

		for (DiasFeriados diaFeriado : listaDiasFeriados) {
			System.out.println("Nueva lista: "+diaFeriado);
		}
		
		return new ResponseEntity<DiasFeriados>(dia_feriado, HttpStatus.OK);
	}
	
}
