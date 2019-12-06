package com.quixada.reuso.restaurante.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Cliente;
import com.quixada.reuso.restaurante.model.Endereco;

@Service
public interface ClienteService {

	List<Cliente> findAll();
	
	Cliente create(Cliente cliente);
	
	Cliente find(Integer id);
	
	void delete(Integer id);
	
	Cliente update(Cliente cliente);
	
	Cliente setEndereco(Integer id, Endereco endereco);
	
}
