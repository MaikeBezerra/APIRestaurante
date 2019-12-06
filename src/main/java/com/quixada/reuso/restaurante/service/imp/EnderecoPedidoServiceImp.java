package com.quixada.reuso.restaurante.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Cliente;
import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.repository.ClienteRepository;
import com.quixada.reuso.restaurante.repository.PedidoRepository;
import com.quixada.reuso.restaurante.service.EnderecoPedidoService;

@Service
public class EnderecoPedidoServiceImp implements EnderecoPedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Pedido setSameEnderecoCliente(Integer idPedido, Integer idCliente) {
		Cliente cliente = clienteRepository.getOne(idCliente);
		Pedido pedido = pedidoRepository.getOne(idPedido);
		
		pedido.setEntrega(cliente.getEndereco());
		return pedidoRepository.save(pedido);
	}

}
