package com.quixada.reuso.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pedido pedido){
		Pedido response = service.create(pedido);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Pedido pedido = service.find(id);
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/pagamento")
	public ResponseEntity<?> finalizarPedido(@PathVariable Integer id, @RequestHeader("pagamento") String pagamento){
		Pedido response = service.payPedido(id, pagamento);
		return ResponseEntity.ok(response);
	}
}
