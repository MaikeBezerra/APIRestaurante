package com.quixada.reuso.restaurante.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.reuso.restaurante.model.Pagamento;
import com.quixada.reuso.restaurante.model.Pedido;
import com.quixada.reuso.restaurante.repository.PedidoRepository;
import com.quixada.reuso.restaurante.service.PedidoService;

@Service
public class PedidoServiceImp implements PedidoService{

	@Autowired 
	private PedidoRepository repository;
	
	@Override
	public Pedido find(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Pedido create(Pedido pedido) {
		return repository.save(pedido);
	}

	@Override
	public Pedido payPedido(Integer id, String pagamento) {
		Pedido pedido = repository.getOne(id);
		pedido.setPagamento(getFormaPagamento(pagamento));
		return repository.save(pedido);
	}
	
	private Pagamento getFormaPagamento(String formaPagamento) {
		switch (formaPagamento) {
		case "credito":
			return Pagamento.CREDITO;
		case "debito":
			return Pagamento.DEBITO;
		default :
			return Pagamento.DINHEIRO;
		}
		
//		return Pagamento.valueOf(formaPagamento.toUpperCase());
	}

}
