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

import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.service.PedidoClienteService;

@RestController
@RequestMapping("/pedidos/cliente")
public class PedidoClienteController {

	@Autowired
	private PedidoClienteService pedidosClienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAll(@PathVariable Integer id){
		List<Pedido> pedidos = pedidosClienteService.findAllByCliente(id);
		return ResponseEntity.ok(pedidos);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> adicinarPedido(@PathVariable Integer id, @RequestBody Pedido pedido){
		Pedido response = pedidosClienteService.addPedido(id, pedido);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}/{idPedido}")
	public ResponseEntity<?> removePedido(@PathVariable("id") Integer id, @PathVariable("idPedido") Integer pedido){
		List<Pedido> response = pedidosClienteService.removePedido(id, pedido);
		return ResponseEntity.ok(response);
	}
	
}
