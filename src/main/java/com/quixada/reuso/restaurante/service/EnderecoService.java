package com.quixada.reuso.restaurante.service;

import com.quixada.reuso.restaurante.model.Endereco;

public interface EnderecoService {
	
	Endereco save(Endereco endereco);
	
	void delete(Integer id);
	
}
