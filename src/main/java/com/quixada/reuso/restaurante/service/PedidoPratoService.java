package com.quixada.reuso.restaurante.service;

import com.quixada.reuso.restaurante.model.Pedido;

public interface PedidoPratoService {

	Pedido addPrato(Integer id, Integer idPrato);

	Pedido removePrato(Integer id, Integer idPrato);
}
