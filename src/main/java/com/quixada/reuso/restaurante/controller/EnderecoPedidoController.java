package com.quixada.reuso.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.service.EnderecoPedidoService;

@RestController
@RequestMapping("/endereco/pedido")
public class EnderecoPedidoController {
	
	@Autowired
	private EnderecoPedidoService endPedidoService;
	
	@PostMapping("/{id}/{idCliente}")
	public ResponseEntity<?> setSameEnderecoCliente(@PathVariable("id") Integer id,
			@PathVariable("idCliente") Integer idCliente){
		
		Pedido response = endPedidoService.setSameEnderecoCliente(id, idCliente);
		
		return ResponseEntity.ok(response);
	}
}
