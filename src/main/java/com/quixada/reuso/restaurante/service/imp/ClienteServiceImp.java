package com.quixada.reuso.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Cliente;
import com.quixada.reuso.restaurante.model.Endereco;
import com.quixada.reuso.restaurante.repository.ClienteRepository;
import com.quixada.reuso.restaurante.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Cliente create(Cliente cliente) {
		
		return repository.save(cliente);
	}

	@Override
	public Cliente find(Integer id) {
		
		return repository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente setEndereco(Integer id, Endereco endereco) {
		Cliente cliente = find(id);
		cliente.setEndereco(endereco);
		
		return repository.save(cliente);
	}
	
	

}
