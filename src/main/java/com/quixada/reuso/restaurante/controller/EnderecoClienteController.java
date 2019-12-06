package com.quixada.reuso.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.reuso.restaurante.model.Cliente;
import com.quixada.reuso.restaurante.model.Endereco;
import com.quixada.reuso.restaurante.service.ClienteService;
import com.quixada.reuso.restaurante.service.EnderecoService;

@RestController
@RequestMapping("/endereco/cliente")
public class EnderecoClienteController {

	@Autowired
	private EnderecoService endService;
	
	@Autowired
	private ClienteService cliService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEnderecoCliente(@PathVariable Integer id){
		Cliente cliente = cliService.find(id);
		return ResponseEntity.ok(cliente.getEndereco());
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> createAndPut(@PathVariable("id") Integer id, @RequestBody Endereco endereco){
		Endereco reference = endService.save(endereco);
		Cliente cliente = cliService.setEndereco(id, reference);
		return ResponseEntity.ok(cliente);
	}
	
}
