package com.quixada.reuso.restaurante.service;

import java.util.List;

import com.quixada.reuso.restaurante.model.Pedido;

public interface PedidoClienteService {

	List<Pedido> findAllByCliente(Integer id);
	
	Pedido addPedido(Integer id, Pedido pedido);
	
	List<Pedido> removePedido(Integer id, Integer idProduto);
	
}
