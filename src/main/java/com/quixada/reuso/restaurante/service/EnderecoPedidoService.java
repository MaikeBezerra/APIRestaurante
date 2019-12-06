package com.quixada.reuso.restaurante.service;

import com.quixada.reuso.restaurante.model.Pedido;

public interface EnderecoPedidoService {
	
	Pedido setSameEnderecoCliente(Integer idPedido, Integer idCliente);
}
