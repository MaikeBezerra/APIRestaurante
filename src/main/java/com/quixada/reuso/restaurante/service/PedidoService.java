package com.quixada.reuso.restaurante.service;

import com.quixada.reuso.restaurante.model.Pedido;

public interface PedidoService {

	Pedido find(Integer id);

	void delete(Integer id);

	Pedido create(Pedido pedido);

	Pedido payPedido(Integer id, String pagamento);

}
