package com.quixada.reuso.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Cliente;
import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.repository.ClienteRepository;
import com.quixada.reuso.restaurante.repository.PedidoRepository;
import com.quixada.reuso.restaurante.service.PedidoClienteService;

@Service
public class PedidoClienteServiceImp implements PedidoClienteService{

	@Autowired
	private ClienteRepository cliRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido addPedido(Integer id, Pedido pedido) {
		Cliente cliente = cliRepository.getOne(id);
		
		pedido.setCliente(cliente);
		
		return pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> findAllByCliente(Integer id) {
		Cliente cliente = cliRepository.getOne(id);
		return pedidoRepository.findByCliente(cliente);
	}

	@Override
	public List<Pedido> removePedido(Integer id, Integer idPedido) {
		pedidoRepository.deleteById(idPedido);
		Cliente cliente = cliRepository.getOne(id);
		
		return pedidoRepository.findByCliente(cliente);
	}

}
