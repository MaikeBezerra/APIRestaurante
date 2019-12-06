package com.quixada.reuso.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Prato;
import com.quixada.reuso.restaurante.repository.PratoRepository;
import com.quixada.reuso.restaurante.service.PratoService;

@Service
public class PratoServiceImp implements PratoService{

	@Autowired
	private PratoRepository repository;
	
	@Override
	public List<Prato> findAll() {
		return repository.findAll();
	}

	@Override
	public Prato create(Prato prato) {
		return repository.save(prato);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Prato find(Integer id) {
		return repository.getOne(id);
	}

}
