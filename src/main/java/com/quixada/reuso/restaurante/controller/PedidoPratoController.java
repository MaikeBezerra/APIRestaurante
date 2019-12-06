package com.quixada.reuso.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.service.PedidoPratoService;

@RestController
@RequestMapping("/pedido")
public class PedidoPratoController {

	@Autowired
	private PedidoPratoService service;
	
	@PostMapping("{id}/{idPrato}")
	public ResponseEntity<?> addPrato(@PathVariable("id") Integer id, @PathVariable("idPrato") Integer idPrato){
		Pedido pedido = service.addPrato(id, idPrato);
		
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping("{id}/{idPrato}")
	public ResponseEntity<?> removePrato(@PathVariable("id") Integer id, @PathVariable("idPrato") Integer idPrato){
		Pedido pedido = service.removePrato(id, idPrato);
		
		return ResponseEntity.ok(pedido);
	}
}
