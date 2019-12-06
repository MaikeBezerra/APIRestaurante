package com.quixada.reuso.restaurante.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Endereco;
import com.quixada.reuso.restaurante.repository.EnderecoRepository;
import com.quixada.reuso.restaurante.service.EnderecoService;

@Service
public class EnderecoServiceImp implements EnderecoService{

	@Autowired
	private EnderecoRepository repository;
	
	@Override
	public Endereco save(Endereco endereco) {
		return repository.save(endereco);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
