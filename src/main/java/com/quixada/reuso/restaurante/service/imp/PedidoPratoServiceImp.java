package com.quixada.reuso.restaurante.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.model.Prato;
import com.quixada.reuso.restaurante.repository.PedidoRepository;
import com.quixada.reuso.restaurante.repository.PratoRepository;
import com.quixada.reuso.restaurante.service.PedidoPratoService;

@Service
public class PedidoPratoServiceImp implements PedidoPratoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PratoRepository pratoRepository;
	
	@Override
	public Pedido addPrato(Integer id, Integer idPrato) {
		Pedido pedido = pedidoRepository.getOne(id);
		Prato prato = pratoRepository.getOne(idPrato);
		
		pedido.getPratos().add(prato);
		pedido.setValorTotal(pedido.getValorTotal() + prato.getPreco());
		return pedidoRepository.save(pedido);
	}
	
	@Override
	public Pedido removePrato(Integer id, Integer idPrato) {
		Pedido pedido = pedidoRepository.getOne(id);
		Prato prato = pratoRepository.getOne(idPrato);
		
		pedido.getPratos().remove(prato);
		pedido.setValorTotal(pedido.getValorTotal() - prato.getPreco());
		return pedidoRepository.save(pedido);
	}

}
