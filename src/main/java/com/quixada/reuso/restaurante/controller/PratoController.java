package com.quixada.reuso.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.reuso.restaurante.model.Prato;
import com.quixada.reuso.restaurante.service.PratoService;

@RestController
@RequestMapping("/pratos")
public class PratoController {

	@Autowired
	private PratoService service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Prato> pratos = service.findAll();
		return ResponseEntity.ok(pratos);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Prato prato) {
		service.create(prato);
		return ResponseEntity.ok().body(prato);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Prato prato = service.find(id);
		return ResponseEntity.ok().body(prato);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
