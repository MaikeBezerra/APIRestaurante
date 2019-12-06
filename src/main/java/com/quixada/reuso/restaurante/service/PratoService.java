package com.quixada.reuso.restaurante.service;

import java.util.List;

import com.quixada.reuso.restaurante.model.Prato;

public interface PratoService {
	
	List<Prato> findAll();
	
	Prato create(Prato prato);
	
	void delete(Integer id);
	
	Prato find(Integer id);
	
}
